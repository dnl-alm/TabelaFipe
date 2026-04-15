package br.com.tabelafipe.domain;

import br.com.tabelafipe.model.DadosDTO;
import br.com.tabelafipe.model.ModelosDTO;
import br.com.tabelafipe.model.VeiculoDTO;
import br.com.tabelafipe.service.ConsumoApi;
import br.com.tabelafipe.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private Scanner scanner = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";
    private String complementoENDERECO = ENDERECO;

    public void exibeMenu(){

        // Mostra o menu inicial para o usuário escolher o tipo de veículo
        System.out.println("Digite qual tipo de veículo você deseja ver: ");
        System.out.println("Carro");
        System.out.println("Moto");
        System.out.println("Caminhão");
        String op = scanner.nextLine();

        // Define a URL base de acordo com o tipo de veículo escolhido
        if (op.equalsIgnoreCase("carro")) {
            complementoENDERECO += "carros/marcas";
        } else if(op.equalsIgnoreCase("moto")) {
            complementoENDERECO += "motos/marcas";
        } else if(op.equalsIgnoreCase("caminhão")) {
            complementoENDERECO += "caminhoes/marcas";
        } else {
            System.out.println("Opção inválida.");
        }

        // Faz a requisição para buscar as marcas na API
        consumoApi = new ConsumoApi();
        var json = consumoApi.obterDados(complementoENDERECO);
        var marcas = conversor.obterLista(json, DadosDTO.class);

        // Ordena e exibe as marcas por código
        marcas.stream()
                .sorted(Comparator.comparing(DadosDTO::codigo))
                .forEach(System.out::println);

        // Usuário escolhe o código da marca
        System.out.println("Informe o código da marca para consulta: ");
        String codMarca = scanner.nextLine();

        // Monta a URL para buscar os modelos da marca escolhida
        complementoENDERECO = complementoENDERECO + "/" + codMarca + "/modelos";
        json = consumoApi.obterDados(complementoENDERECO);
        var modeloLista = conversor.obterDados(json, ModelosDTO.class);

        // Exibe os modelos da marca escolhida
        System.out.println("Modelos desta marca: ");
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(DadosDTO::codigo))
                .forEach(System.out::println);

        // Usuário digita parte do nome do modelo para filtrar
        System.out.println("Digite o veículo que deseja buscar: ");
        var nome = scanner.nextLine();

        // Filtra modelos pelo nome digitado (busca parcial, ignorando maiúsculas/minúsculas)
        List<DadosDTO> modelosFiltrados = modeloLista.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList());

        // Exibe os modelos filtrados
        System.out.println("Modelos filtrados: ");
        modelosFiltrados.forEach(System.out::println);

        // Usuário escolhe o código do modelo
        System.out.println("Digite o código do modelo que deseja ver:");
        var codigoModelo = scanner.nextLine();

        // Monta URL para buscar os anos daquele modelo
        complementoENDERECO = complementoENDERECO + "/" + codigoModelo + "/anos";

        json = consumoApi.obterDados(complementoENDERECO);
        List<DadosDTO> anos = conversor.obterLista(json, DadosDTO.class);

        // Lista final de veículos completos (ano + valor + etc.)
        List<VeiculoDTO> listaVeiculos = new ArrayList<>();

        // Para cada ano disponível, busca os dados completos do veículo
        for (int i = 0; i < anos.size(); i++) {

            // Monta endpoint específico do ano
            var enderecoAnos = complementoENDERECO + "/" + anos.get(i).codigo();
            json = consumoApi.obterDados(enderecoAnos);
            VeiculoDTO veiculoDTO = conversor.obterDados(json, VeiculoDTO.class);

            // Adiciona na lista final
            listaVeiculos.add(veiculoDTO);
        }

        // Exibe todos os veículos encontrados com seus anos e valores
        System.out.println("\nVeículos filtrados com avaliação por anos:");
        listaVeiculos.forEach(System.out::println);
    }
}
