package br.com.zupacademy.gabrielf.casadocodigo.config.validacao;

import java.time.LocalDateTime;

public class ErroDeMensagemDto {
    private String message;
    private String campo;
    private LocalDateTime timestamp;

    public ErroDeMensagemDto(String message, String campo, LocalDateTime timestamp) {
        this.message = message;
        this.campo = campo;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getCampo() {
        return campo;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
