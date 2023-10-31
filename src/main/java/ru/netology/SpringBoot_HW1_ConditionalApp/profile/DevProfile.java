package ru.netology.SpringBoot_HW1_ConditionalApp.profile;

//@Configuration - либо так, но без JavaConfig
//@ConditionalOnProperty(prefix = "netology", name = "profile.dev", havingValue = "true")
public class DevProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is dev";
    }
}
