package com.kodilla.mockito.homework;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WeatherNotificationService {
    private Set<Subscriber> generalSubscribers = new HashSet<>();

    private Set<Subscriber> localisationSubscribers = new HashSet<>();

    private Set<Localisation> subscriberLocalisations = new HashSet<>();

    private Map<Subscriber, Set<Localisation> > subscribersLocalisationsMap = new HashMap<>();

    private Set<Localisation> generalLocalisations = new HashSet<>();

    public void addGeneralSubscriber(Subscriber subscriber) {
        this.generalSubscribers.add(subscriber);
    }

    public void removeGeneralSubscriber(Subscriber subscriber) {
        this.generalSubscribers.remove(subscriber);
    }

    public void addGeneralLocalisation(Localisation localisation){ generalLocalisations.add(localisation); }

    public void addLocalisationSubscriber(Subscriber subscriber, Localisation localisation) {
        addGeneralSubscriber(subscriber);
        this.localisationSubscribers.add(subscriber);
            subscriberLocalisations.add(localisation);
            subscribersLocalisationsMap.put(subscriber, subscriberLocalisations);
    }

    public void removeLocalisationSubscriber(Subscriber subscriber, Localisation localisation) {
        this.localisationSubscribers.remove(subscriber);
        for (Map.Entry<Subscriber, Set<Localisation>> userLocalisation : subscribersLocalisationsMap.entrySet()){
            userLocalisation.getValue().remove(localisation);
        }
    }

    public int returnNumberOfSubscribedLocalisationPerUser(Subscriber subscriber) throws Exception {
            return subscribersLocalisationsMap.get(subscriber).size();
    }

    public void removeSubscriberIfAllLocalisationUnsubscribed(Subscriber subscriber) throws Exception {
        if (returnNumberOfSubscribedLocalisationPerUser(subscriber)==0)
                removeGeneralSubscriber(subscriber);
    }

    public void removeLocalisation(Localisation localisation) {
        generalLocalisations.remove(localisation);
        for (Map.Entry<Subscriber, Set<Localisation>> userLocalisation : subscribersLocalisationsMap.entrySet()){
            userLocalisation.getValue().remove(localisation);
        }
    }

    public void sendGeneralNotification(WeatherNotification weatherNotification) {
        this.generalSubscribers.forEach(subscriber -> subscriber.receiveGeneralNotification(weatherNotification));
    }

    public void sendLocalisationNotification(WeatherNotification weatherNotification, Localisation localisation) {
        if (generalLocalisations.contains(localisation)){
        this.localisationSubscribers
                .forEach(subscriber -> subscriber.receiveLocalisationNotification(weatherNotification,localisation));
        }else {
            System.out.println("Can not send notification to non existing provided localisation: " + localisation);
        }
    }
}
