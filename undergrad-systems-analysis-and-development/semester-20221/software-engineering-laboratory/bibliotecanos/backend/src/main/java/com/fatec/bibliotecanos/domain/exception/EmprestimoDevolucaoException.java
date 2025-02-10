package com.fatec.bibliotecanos.domain.exception;

public class EmprestimoDevolucaoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public EmprestimoDevolucaoException(String msg) {
        super(msg);
    }

}