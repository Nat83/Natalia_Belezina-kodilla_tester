package com.kodilla.mockito.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class WeatherNotificationServiceTestSuite {

    WeatherNotificationService weatherNotificationService = new WeatherNotificationService();
    Subscriber subscriber1 = Mockito.mock(Subscriber.class);
    Subscriber subscriber2 = Mockito.mock(Subscriber.class);
    Subscriber subscriber3 = Mockito.mock(Subscriber.class);
    Subscriber subscriber4 = Mockito.mock(Subscriber.class);
    Subscriber subscriber5 = Mockito.mock(Subscriber.class);
    Localisation Wroclaw = Mockito.mock(Localisation.class);
    Localisation Krakow = Mockito.mock(Localisation.class);
    Localisation Gdansk = Mockito.mock(Localisation.class);
    WeatherNotification weatherNotification = Mockito.mock(WeatherNotification.class);

    @BeforeEach
    public void PrepareListOfLocalisations() {
        weatherNotificationService.addGeneralLocalisation(Wroclaw);
        weatherNotificationService.addGeneralLocalisation(Krakow);
        weatherNotificationService.addGeneralLocalisation(Gdansk);
    }

    @Test
    public void notSubscribedPeopleShouldNotReceiveNotification() {
        weatherNotificationService.sendGeneralNotification(weatherNotification);

        Mockito.verify(subscriber1, Mockito.never()).receiveGeneralNotification(weatherNotification);
    }

    @Test
    public void generalSubscriberNotSubscribedToLocalisationShouldReceiveGeneralNotification() {
        weatherNotificationService.addGeneralSubscriber(subscriber1);
        weatherNotificationService.sendGeneralNotification(weatherNotification);

        Mockito.verify(subscriber1).receiveGeneralNotification(weatherNotification);
    }

    @Test
    public void generalSubscriberNotSubscribedToLocalisationShouldNotReceiveLocalNotification() {
        weatherNotificationService.addGeneralSubscriber(subscriber1);
        weatherNotificationService.sendGeneralNotification(weatherNotification);

        Mockito.verify(subscriber1, Mockito.never()).receiveLocalisationNotification(weatherNotification, Wroclaw);
    }

    @Test
    public void subscribedPersonShouldReceiveNotification() {
        weatherNotificationService.addGeneralSubscriber(subscriber1);
        weatherNotificationService.sendGeneralNotification(weatherNotification);

        Mockito.verify(subscriber1).receiveGeneralNotification(weatherNotification);
    }

    @Test
    public void allSubscribedPeopleShouldReceiveNotification() {
        addGeneralSubscribers(subscriber1, subscriber2, subscriber3, subscriber4, subscriber5);
        weatherNotificationService.sendGeneralNotification(weatherNotification);

        Mockito.verify(subscriber1).receiveGeneralNotification(weatherNotification);
        Mockito.verify(subscriber2).receiveGeneralNotification(weatherNotification);
        Mockito.verify(subscriber3).receiveGeneralNotification(weatherNotification);
        Mockito.verify(subscriber4).receiveGeneralNotification(weatherNotification);
        Mockito.verify(subscriber5).receiveGeneralNotification(weatherNotification);
    }

    @Test
    public void personSubscribedToLocalisationShouldReceiveLocalWeatherNotificationForThatLocalisation() {
        weatherNotificationService.addLocalisationSubscriber(subscriber3, Gdansk);
        weatherNotificationService.sendLocalisationNotification(weatherNotification, Gdansk);

        Mockito.verify(subscriber3).receiveLocalisationNotification(weatherNotification, Gdansk);
    }

    @Test
    public void personSubscribedToFewLocalisationShouldReceiveLocalWeatherNotificationForAllSubscribedLocalisation() {
        weatherNotificationService.addLocalisationSubscriber(subscriber3, Gdansk);
        weatherNotificationService.addLocalisationSubscriber(subscriber3, Wroclaw);
        weatherNotificationService.addLocalisationSubscriber(subscriber3, Krakow);
        weatherNotificationService.sendLocalisationNotification(weatherNotification, Gdansk);
        weatherNotificationService.sendLocalisationNotification(weatherNotification, Wroclaw);
        weatherNotificationService.sendLocalisationNotification(weatherNotification, Krakow);

        Mockito.verify(subscriber3).receiveLocalisationNotification(weatherNotification, Gdansk);
        Mockito.verify(subscriber3).receiveLocalisationNotification(weatherNotification, Wroclaw);
        Mockito.verify(subscriber3).receiveLocalisationNotification(weatherNotification, Krakow);
    }

    @Test
    public void personUnsubscribedFromLocalisationDoesNotReceiveLocalWeatherNotification() {
        addSubscribersToLocalisation(Krakow, subscriber2, subscriber5, subscriber4);
        weatherNotificationService.removeLocalisationSubscriber(subscriber5, Krakow);
        weatherNotificationService.sendLocalisationNotification(weatherNotification, Krakow);

        Mockito.verify(subscriber1, Mockito.never()).receiveLocalisationNotification(weatherNotification, Krakow);
    }

    @Test
    public void localWeatherNotificationShouldBeSentOnlyToLocalisationSubscribers() {
        addSubscribersToLocalisation(Wroclaw, subscriber1, subscriber5, subscriber3);
        weatherNotificationService.sendLocalisationNotification(weatherNotification, Wroclaw);

        Mockito.verify(subscriber1).receiveLocalisationNotification(weatherNotification, Wroclaw);
        Mockito.verify(subscriber5).receiveLocalisationNotification(weatherNotification, Wroclaw);
        Mockito.verify(subscriber3).receiveLocalisationNotification(weatherNotification, Wroclaw);
        Mockito.verify(subscriber2, Mockito.never()).receiveLocalisationNotification(weatherNotification, Wroclaw);
    }

    @Test
    public void subscribingToLocalisationIsCreatingGeneralSubscription() {
        weatherNotificationService.addLocalisationSubscriber(subscriber3, Gdansk);
        weatherNotificationService.sendGeneralNotification(weatherNotification);

        Mockito.verify(subscriber3).receiveGeneralNotification(weatherNotification);
    }

    @Test
    public void unsubscribingFromAllLocalisationsIsRemovingGeneralSubscription() throws Exception {
        weatherNotificationService.addLocalisationSubscriber(subscriber1, Gdansk);
        weatherNotificationService.addLocalisationSubscriber(subscriber1, Wroclaw);
        weatherNotificationService.addLocalisationSubscriber(subscriber1, Krakow);
        weatherNotificationService.removeLocalisationSubscriber(subscriber1, Gdansk);
        weatherNotificationService.removeLocalisationSubscriber(subscriber1, Wroclaw);
        weatherNotificationService.removeLocalisationSubscriber(subscriber1, Krakow);
        System.out.println(weatherNotificationService.returnNumberOfSubscribedLocalisationPerUser(subscriber1));
        weatherNotificationService.removeSubscriberIfAllLocalisationUnsubscribed(subscriber1);
        weatherNotificationService.sendGeneralNotification(weatherNotification);

        Mockito.verify(subscriber1, Mockito.never()).receiveGeneralNotification(weatherNotification);
    }

    @Test
    public void shouldBePossibleToCancelLocalisationSubscription() throws Exception {
        weatherNotificationService.addLocalisationSubscriber(subscriber1, Gdansk);
        weatherNotificationService.addLocalisationSubscriber(subscriber1, Wroclaw);
        weatherNotificationService.addLocalisationSubscriber(subscriber1, Krakow);
        weatherNotificationService.removeLocalisation(Gdansk);
        System.out.println(weatherNotificationService.returnNumberOfSubscribedLocalisationPerUser(subscriber1));
        weatherNotificationService.sendLocalisationNotification(weatherNotification, Gdansk);
        weatherNotificationService.sendLocalisationNotification(weatherNotification, Wroclaw);
        weatherNotificationService.sendLocalisationNotification(weatherNotification, Krakow);

        Mockito.verify(subscriber1).receiveLocalisationNotification(weatherNotification, Wroclaw);
        Mockito.verify(subscriber1).receiveLocalisationNotification(weatherNotification, Krakow);
        Mockito.verify(subscriber1, Mockito.never()).receiveLocalisationNotification(weatherNotification, Gdansk);
    }

    private void addGeneralSubscribers(Subscriber... subscribers) {
        for (Subscriber currentSubscriber : subscribers) {
            weatherNotificationService.addGeneralSubscriber(currentSubscriber);
        }
    }

    private void addSubscribersToLocalisation(Localisation localisation, Subscriber... subscribers) {
        for (Subscriber currentSubscriber : subscribers) {
            weatherNotificationService.addLocalisationSubscriber(currentSubscriber, localisation);
        }
    }
}