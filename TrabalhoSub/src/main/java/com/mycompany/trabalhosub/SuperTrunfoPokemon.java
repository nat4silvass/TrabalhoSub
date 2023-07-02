
import com.mycompany.trabalhosub.ComparadorAgilidadePokemon;
import com.mycompany.trabalhosub.ComparadorAtaquePokemon;
import com.mycompany.trabalhosub.ComparadorDefesaPokemon;
import com.mycompany.trabalhosub.ComparadorForcaPokemon;
import com.mycompany.trabalhosub.Pokemon;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SuperTrunfoPokemon {
    private static List<Pokemon> listaPokemon = new ArrayList<>();
    private static List<Pokemon> filaJogador1 = new ArrayList<>();
    private static List<Pokemon> filaJogador2 = new ArrayList<>();

    public static void main(String[] args) {
        boolean sair = false;

        while (!sair) {
            String opcao = JOptionPane.showInputDialog(
                    "Selecione uma opção:\n" +
                    "1 - Cadastrar Pokémon\n" +
                    "2 - Iniciar batalha\n" +
                    "3 - Mostrar Pokémon\n" +
                    "0 - Sair");

            switch (opcao) {
                case "1":
                    cadastrarPokemon();
                    break;
                case "2":
                    iniciarBatalha();
                    break;
                case "3":
                    mostrarPokemon();
                    break;
                case "0":
                    sair = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }

    private static void cadastrarPokemon() {
        String nome = JOptionPane.showInputDialog("Digite o nome do Pokémon:");
        int forca = Integer.parseInt(JOptionPane.showInputDialog("Digite a força do Pokémon:"));
        int ataque = Integer.parseInt(JOptionPane.showInputDialog("Digite o ataque do Pokémon:"));
        int defesa = Integer.parseInt(JOptionPane.showInputDialog("Digite a defesa do Pokémon:"));
        int agilidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a agilidade do Pokémon:"));

        Pokemon novoPokemon = new Pokemon(nome, forca, ataque, defesa, agilidade);
        listaPokemon.add(novoPokemon);

        JOptionPane.showMessageDialog(null, "Pokémon cadastrado com sucesso!");
    }

    private static void iniciarBatalha() {
        filaJogador1.clear();
        filaJogador2.clear();

       
        String mensagemJogador1 = "Selecione 3 Pokémon para o jogador 1:\n";
        for (int i = 0; i < 3; i++) {
            String numeroPokemon = JOptionPane.showInputDialog("Digite o número do Pokémon para o jogador 1:");
            int numero = Integer.parseInt(numeroPokemon);
            Pokemon pokemon = buscarPokemon(numero);
            if (pokemon != null) {
                filaJogador1.add(pokemon);
                mensagemJogador1 += numeroPokemon + " - " + pokemon.getNome() + "\n";
            } else {
                JOptionPane.showMessageDialog(null, "Número de Pokémon inválido!");
                i--;
            }
        }

       
        String mensagemJogador2 = "Selecione 3 Pokémon para o jogador 2:\n";
        for (int i = 0; i < 3; i++) {
            String numeroPokemon = JOptionPane.showInputDialog("Digite o número do Pokémon para o jogador 2:");
            int numero = Integer.parseInt(numeroPokemon);
            Pokemon pokemon = buscarPokemon(numero);
            if (pokemon != null) {
                filaJogador2.add(pokemon);
                mensagemJogador2 += numeroPokemon + " - " + pokemon.getNome() + "\n";
            } else {
                JOptionPane.showMessageDialog(null, "Número de Pokémon inválido!");
                i--;
            }
        }

        
        String mensagemPokemonsSelecionados = "Pokémon selecionados para a batalha:\n\n";
        mensagemPokemonsSelecionados += "Jogador 1:\n" + mensagemJogador1 + "\n";
        mensagemPokemonsSelecionados += "Jogador 2:\n" + mensagemJogador2;
        JOptionPane.showMessageDialog(null, mensagemPokemonsSelecionados);
        
          for (Pokemon pokemon : filaJogador1) {
        JOptionPane.showMessageDialog(null, "Atributos do Pokémon " + pokemon.getNome() + " do Jogador 1:\n" +
                "Força: " + pokemon.getForca() + "\n" +
                "Ataque: " + pokemon.getAtaque() + "\n" +
                "Defesa: " + pokemon.getDefesa() + "\n" +
                "Agilidade: " + pokemon.getAgilidade());
    }

    for (Pokemon pokemon : filaJogador2) {
        JOptionPane.showMessageDialog(null, "Atributos do Pokémon " + pokemon.getNome() + " do Jogador 2:\n" +
                "Força: " + pokemon.getForca() + "\n" +
                "Ataque: " + pokemon.getAtaque() + "\n" +
                "Defesa: " + pokemon.getDefesa() + "\n" +
                "Agilidade: " + pokemon.getAgilidade());
    }

        
        filaJogador1.sort(new ComparadorForcaPokemon());
        filaJogador2.sort(new ComparadorForcaPokemon());

        
        int rodada = 1;
        while (!filaJogador1.isEmpty() && !filaJogador2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Rodada " + rodada + "!\n");

            Pokemon pokemonJogador1 = selecionarPokemon(filaJogador1, "Jogador 1");
            Pokemon pokemonJogador2 = selecionarPokemon(filaJogador2, "Jogador 2");

            if (pokemonJogador1 != null && pokemonJogador2 != null) {
                int golpe = Integer.parseInt(JOptionPane.showInputDialog("Selecione o golpe a ser utilizado:\n" +
                        "1 - Força\n" +
                        "2 - Ataque\n" +
                        "3 - Defesa\n" +
                        "4 - Agilidade"));

                switch (golpe) {
                    case 1:
                        compararAtributo(pokemonJogador1, pokemonJogador2, "força");
                        break;
                    case 2:
                        compararAtributo(pokemonJogador1, pokemonJogador2, "ataque");
                        break;
                    case 3:
                        compararAtributo(pokemonJogador1, pokemonJogador2, "defesa");
                        break;
                    case 4:
                        compararAtributo(pokemonJogador1, pokemonJogador2, "agilidade");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                }

                if (pokemonJogador1.getForca() <= 0) {
                    filaJogador1.remove(pokemonJogador1);
                }

                if (pokemonJogador2.getForca() <= 0) {
                    filaJogador2.remove(pokemonJogador2);
                }

                rodada++;
            }
        }

        if (filaJogador1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Jogador 2 venceu a batalha!");
        } else if (filaJogador2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Jogador 1 venceu a batalha!");
        }
    }

    private static void mostrarPokemon() {
        String opcao = JOptionPane.showInputDialog("Selecione uma opção:\n" +
                "1 - Exibir todos os atributos\n" +
                "2 - Exibir pokémons ordenados por atributo\n" +
                "3 - Selecionar pokémon desejado\n" +
                "4 - Sequencial Fibonacci");

        switch (opcao) {
            case "1":
                exibirTodosAtributos();
                break;
            case "2":
                String atributoOrdenacao = JOptionPane.showInputDialog("Selecione o atributo para ordenar os pokémons:\n" +
                        "1 - Força\n" +
                        "2 - Ataque\n" +
                        "3 - Defesa\n" +
                        "4 - Agilidade");
                ordenarPorAtributo(Integer.parseInt(atributoOrdenacao));
                break;
            case "3":
                String numeroPokemon = JOptionPane.showInputDialog("Digite o número do pokémon desejado:");
                exibirPokemon(Integer.parseInt(numeroPokemon));
                break;
            case "4":
                String numeroFibonacci = JOptionPane.showInputDialog("Digite o número do pokémon para o sequencial Fibonacci:");
                sequencialFibonacci(Integer.parseInt(numeroFibonacci));
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida!");
        }
    }

    private static void exibirTodosAtributos() {
        String quantidadePokemons = JOptionPane.showInputDialog("Digite a quantidade de pokémons a serem exibidos:");
        int quantidade = Integer.parseInt(quantidadePokemons);

        if (quantidade > listaPokemon.size()) {
            JOptionPane.showMessageDialog(null, "Quantidade de pokémons maior que o total cadastrado!");
            return;
        }

        String mensagem = "Dados dos pokémons:\n";
        for (int i = 0; i < quantidade; i++) {
            Pokemon pokemon = listaPokemon.get(i);
            mensagem += "Número: " + (i + 1) + "\n" +
                    "Nome: " + pokemon.getNome() + "\n" +
                    "Força: " + pokemon.getForca() + "\n" +
                    "Ataque: " + pokemon.getAtaque() + "\n" +
                    "Defesa: " + pokemon.getDefesa() + "\n" +
                    "Agilidade: " + pokemon.getAgilidade() + "\n\n";
        }

        JOptionPane.showMessageDialog(null, mensagem);
    }

    private static void ordenarPorAtributo(int atributo) {
        Comparator<Pokemon> comparador = null;

        switch (atributo) {
            case 1:
                comparador = new ComparadorForcaPokemon();
                break;
            case 2:
                comparador = new ComparadorAtaquePokemon();
                break;
            case 3:
                comparador = new ComparadorDefesaPokemon();
                break;
            case 4:
                comparador = new ComparadorAgilidadePokemon();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                return;
        }

        List<Pokemon> listaOrdenada = new ArrayList<>(listaPokemon);
        listaOrdenada.sort(comparador);

        String mensagem = "Pokémons ordenados pelo atributo:\n";
        for (Pokemon pokemon : listaOrdenada) {
            mensagem += "Número: " + (listaPokemon.indexOf(pokemon) + 1) + "\n" +
                    "Nome: " + pokemon.getNome() + "\n" +
                    "Força: " + pokemon.getForca() + "\n" +
                    "Ataque: " + pokemon.getAtaque() + "\n" +
                    "Defesa: " + pokemon.getDefesa() + "\n" +
                    "Agilidade: " + pokemon.getAgilidade() + "\n\n";
        }

        JOptionPane.showMessageDialog(null, mensagem);
    }

    private static void exibirPokemon(int numero) {
        Pokemon pokemon = buscarPokemon(numero);

        if (pokemon != null) {
            String mensagem = "Dados do pokémon:\n" +
                    "Número: " + numero + "\n" +
                    "Nome: " + pokemon.getNome() + "\n" +
                    "Força: " + pokemon.getForca() + "\n" +
                    "Ataque: " + pokemon.getAtaque() + "\n" +
                    "Defesa: " + pokemon.getDefesa() + "\n" +
                    "Agilidade: " + pokemon.getAgilidade() + "\n";

            JOptionPane.showMessageDialog(null, mensagem);
        } else {
            JOptionPane.showMessageDialog(null, "Pokémon não encontrado!");
        }
    }

    private static void sequencialFibonacci(int quantidade) {
        List<Pokemon> listaFibonacci = new ArrayList<>();

        int a = 0;
        int b = 1;
        for (int i = 0; i < quantidade; i++) {
            int forca = a + b;
            int ataque = a + b;
            int defesa = a + b;
            int agilidade = a + b;

            Pokemon fibonacci = new Pokemon("Fibonacci", forca, ataque, defesa, agilidade);
            listaFibonacci.add(fibonacci);

            a = b;
            b = forca;
        }

        String mensagem = "Pokémons sequencial Fibonacci:\n";
        for (Pokemon pokemon : listaFibonacci) {
            mensagem += "Número: " + (listaFibonacci.indexOf(pokemon) + 1) + "\n" +
                    "Nome: " + pokemon.getNome() + "\n" +
                    "Força: " + pokemon.getForca() + "\n" +
                    "Ataque: " + pokemon.getAtaque() + "\n" +
                    "Defesa: " + pokemon.getDefesa() + "\n" +
                    "Agilidade: " + pokemon.getAgilidade() + "\n\n";
        }

        JOptionPane.showMessageDialog(null, mensagem);
    }

    private static Pokemon selecionarPokemon(List<Pokemon> fila, String jogador) {
        String mensagem = "Selecione o Pokémon para " + jogador + ":\n";
        for (int i = 0; i < fila.size(); i++) {
            Pokemon pokemon = fila.get(i);
            mensagem += (i + 1) + " - " + pokemon.getNome() + "\n";
        }

        String numeroPokemon = JOptionPane.showInputDialog(mensagem);
        int numero = Integer.parseInt(numeroPokemon);

        if (numero >= 1 && numero <= fila.size()) {
            return fila.get(numero - 1);
        } else {
            JOptionPane.showMessageDialog(null, "Número de Pokémon inválido!");
            return null;
        }
    }

    private static void compararAtributo(Pokemon pokemon1, Pokemon pokemon2, String atributo) {
        switch (atributo) {
            case "força":
                if (pokemon1.getForca() > pokemon2.getForca()) {
                    aplicarDano(pokemon2, pokemon1.getForca());
                    JOptionPane.showMessageDialog(null, "Pokémon 1 venceu a rodada!");
                } else if (pokemon2.getForca() > pokemon1.getForca()) {
                    aplicarDano(pokemon1, pokemon2.getForca());
                    JOptionPane.showMessageDialog(null, "Pokémon 2 venceu a rodada!");
                } else {
                    JOptionPane.showMessageDialog(null, "Empate!");
                }
                break;
            case "ataque":
                if (pokemon1.getAtaque() > pokemon2.getAtaque()) {
                    aplicarDano(pokemon2, pokemon1.getAtaque());
                    JOptionPane.showMessageDialog(null, "Pokémon 1 venceu a rodada!");
                } else if (pokemon2.getAtaque() > pokemon1.getAtaque()) {
                    aplicarDano(pokemon1, pokemon2.getAtaque());
                    JOptionPane.showMessageDialog(null, "Pokémon 2 venceu a rodada!");
                } else {
                    JOptionPane.showMessageDialog(null, "Empate!");
                }
                break;
            case "defesa":
                if (pokemon1.getDefesa() > pokemon2.getDefesa()) {
                    aplicarDano(pokemon2, pokemon1.getDefesa());
                    JOptionPane.showMessageDialog(null, "Pokémon 1 venceu a rodada!");
                } else if (pokemon2.getDefesa() > pokemon1.getDefesa()) {
                    aplicarDano(pokemon1, pokemon2.getDefesa());
                    JOptionPane.showMessageDialog(null, "Pokémon 2 venceu a rodada!");
                } else {
                    JOptionPane.showMessageDialog(null, "Empate!");
                }
                break;
            case "agilidade":
                if (pokemon1.getAgilidade() > pokemon2.getAgilidade()) {
                    aplicarDano(pokemon2, pokemon1.getAgilidade());
                    JOptionPane.showMessageDialog(null, "Pokémon 1 venceu a rodada!");
                } else if (pokemon2.getAgilidade() > pokemon1.getAgilidade()) {
                    aplicarDano(pokemon1, pokemon2.getAgilidade());
                    JOptionPane.showMessageDialog(null, "Pokémon 2 venceu a rodada!");
                } else {
                    JOptionPane.showMessageDialog(null, "Empate!");
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Atributo inválido!");
        }
    }

    private static void aplicarDano(Pokemon pokemon, int valor) {
        int novoValor = pokemon.getForca() - valor;
        pokemon.setForca(novoValor);
    }

    private static Pokemon buscarPokemon(int numero) {
        if (numero >= 1 && numero <= listaPokemon.size()) {
            return listaPokemon.get(numero - 1);
        } else {
            return null;
        }
    }
}
