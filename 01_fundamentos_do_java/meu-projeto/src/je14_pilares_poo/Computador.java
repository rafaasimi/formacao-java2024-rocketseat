package je14_pilares_poo;

public class Computador {

    public static void main(String[] args) {

        ServicoMensagemInstantanea smi = null;
        String appEscolhido = "fbmessenger";

        if (appEscolhido.equals("msn")) {
            smi = new MSNMessenger();
        } else if (appEscolhido.equals("fbmessenger")) {
            smi = new FacebookMessenger();
        } else if (appEscolhido.equals("teelgram")) {
            smi = new Telegram();
        }

        smi.enviarMensagem();
        smi.receberMensagem();
    }

}
