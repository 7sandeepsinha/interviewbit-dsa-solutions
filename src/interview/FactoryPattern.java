package interview;

// abstract class API -> conc. API getProduct()
//

 interface Notification{
    void sendNotification();
}

class MailNotifier implements Notification{
     public void sendNotification(){
         System.out.println("Sent notification to user by Email");
     }
}


class SMSNotifier implements Notification{
     public void sendNotification(){
         System.out.println("Sent notification to user by SMS");
     }
}

class NotificationFactory{

     public Notification createNotifier(String type){
         Notification notificationObj = null;
         if(type.equals(NotificationTypes.MAIL.toString())){
             notificationObj = new MailNotifier();
         }

         if(type.equals(NotificationTypes.SMS.toString())){
             notificationObj = new SMSNotifier();
         }

         return notificationObj;
     }
}


enum NotificationTypes{
     MAIL,SMS;
}

 class Singleton{
    private  static Singleton obj = null;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(obj == null){
            obj = new Singleton();
        }
        return obj;
    }
}