package je14_pilares_poo;

public class Computador {

    public static void main(String[] args) {

        MSNMessenger msn = new MSNMessenger();

        msn.enviarMensagem();
        msn.receberMensagem();
//        msn.validarConectadoInternet();
//        msn.salvarHistoricoMensagem();

        FacebookMessenger facebookMessenger = new FacebookMessenger();
        facebookMessenger.enviarMensagem();
        facebookMessenger.receberMensagem();

        Telegram telegram = new Telegram();
        telegram.enviarMensagem();
        telegram.receberMensagem();

    }

}
