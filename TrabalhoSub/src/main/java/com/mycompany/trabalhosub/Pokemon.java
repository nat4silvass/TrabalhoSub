package com.mycompany.trabalhosub;

public class Pokemon {

    private static int proximoNumero = 1;

    private int numero;
    private String nome;
    private int forca;
    private int ataque;
    private int defesa;
    private int agilidade;

    public Pokemon(String nome, int forca, int ataque, int defesa, int agilidade) {
        this.numero = proximoNumero++;
        this.nome = nome;
        this.forca = forca;
        this.ataque = ataque;
        this.defesa = defesa;
        this.agilidade = agilidade;
    }

    public static void setProximoNumero(int proximoNumero) {
        Pokemon.proximoNumero = proximoNumero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }
    
    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public int getForca() {
        return forca;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getAgilidade() {
        return agilidade;
    }
}