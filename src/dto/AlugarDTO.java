/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Date;

/**
 *
 * @author Eduardo
 */
public class AlugarDTO {
    private int cod;
    private int cod_cliente;
    private int cod_livro;
    private String data_inicial;
    private String data_final;
    private String status;

    /**
     * @return the cod
     */
    public int getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(int cod) {
        this.cod = cod;
    }

    /**
     * @return the cod_cliente
     */
    public int getCod_cliente() {
        return cod_cliente;
    }

    /**
     * @param cod_cliente the cod_cliente to set
     */
    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    /**
     * @return the cod_livro
     */
    public int getCod_livro() {
        return cod_livro;
    }

    /**
     * @param cod_livro the cod_livro to set
     */
    public void setCod_livro(int cod_livro) {
        this.cod_livro = cod_livro;
    }

    /**
     * @return the data_inicial
     */
    public String getData_inicial() {
        return data_inicial;
    }

    /**
     * @param data_inicial the data_inicial to set
     */
    public void setData_inicial(String data_inicial) {
        this.data_inicial = data_inicial;
    }

    /**
     * @return the data_final
     */
    public String getData_final() {
        return data_final;
    }

    /**
     * @param data_final the data_final to set
     */
    public void setData_final(String data_final) {
        this.data_final = data_final;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
