package ru.stqa.pft.mantis.appmanager;

import org.subethamail.wiser.Wiser;

public class MailHelper {

    private ApplicationManager app;
    private final Wiser wiser;

    public MailHelper(ApplicationManager app){
        this.app = app;
        wiser = new Wiser();
    }

   /* public List<MailMessage> waitFromMail(int count, long timeout) throws MessagingException, IOException {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() < start + timeout){
            if(wiser.getMessages().size() >= count){
                return wiser.getMessages().stream().map((m) -> toModelMain(m)).collect(Collectors.toList());
            }
        }
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new Error("No mail");
    }*/

}
