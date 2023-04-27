package com.kodilla.mockito.homework;

public interface Subscriber {
    void receiveGeneralNotification(WeatherNotification weatherNotification);

    void receiveLocalisationNotification(WeatherNotification weatherNotification, Localisation localisation);
}
