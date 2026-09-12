package in.ggklass.profileDemo;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class NotificationServiceImpl implements NotificationService {
    @Override
    public String sendNotification() {
        return "new notification coming...";
    }
}
