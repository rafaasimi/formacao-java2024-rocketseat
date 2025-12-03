package je14_pilares_poo;

public class SistemaMensagemInstantanea {

    public void enviarMensagem() {
        if (validarConectadoInternet()) {
            System.out.println("Enviando mensagem");
        } else {
            System.out.println("Falha ao enviar mensagem");
        }
    }

    public void receberMensagem() {
        System.out.println("Recebendo mensagem");
    }

    private boolean validarConectadoInternet() {
        System.out.println("Validando se está conectado a internet");
        return true;
    }

    private void salvarHistoricoMensagem() {
        System.out.println("Salvando histórico de mensagens");
    }

}
