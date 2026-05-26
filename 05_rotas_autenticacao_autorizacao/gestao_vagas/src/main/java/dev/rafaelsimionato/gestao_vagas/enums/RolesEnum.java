package dev.rafaelsimionato.gestao_vagas.enums;

public enum RolesEnum {
    CANDIDATE, COMPANY;

    @Override
    public String toString() {
        return this.name();
    }
}
