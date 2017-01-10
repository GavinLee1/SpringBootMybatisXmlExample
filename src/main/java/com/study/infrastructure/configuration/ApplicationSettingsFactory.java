package com.study.infrastructure.configuration;

public class ApplicationSettingsFactory {
	private static IApplicationSettings applicationSettings;

    public static void initializeApplicationSettingsFactory(IApplicationSettings applicationSettings){
        ApplicationSettingsFactory.applicationSettings = applicationSettings;
    }

    public static IApplicationSettings getApplicationSettings(){
        return ApplicationSettingsFactory.applicationSettings;
    }
}
