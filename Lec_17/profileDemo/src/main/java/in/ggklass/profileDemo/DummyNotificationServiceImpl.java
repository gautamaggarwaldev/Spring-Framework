package in.ggklass.profileDemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"dev", "default", "staging"})
public class DummyNotificationServiceImpl implements NotificationService{
    @Override
    public String sendNotification() {
        return "Here is a dummy notification coming...";
    }


}
