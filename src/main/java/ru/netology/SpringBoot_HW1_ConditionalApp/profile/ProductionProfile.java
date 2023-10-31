package ru.netology.SpringBoot_HW1_ConditionalApp.profile;

//@Configuration - либо так, но без JavaConfig
//@ConditionalOnProperty(prefix = "netology", name = "profile.dev", havingValue = "false")
public class ProductionProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is production";
    }
}
