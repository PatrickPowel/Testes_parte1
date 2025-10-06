package br.rpires;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<>();

        System.out.println("Digite o nome e o sexo separados por vírgula (ex: Ana,F ou João,M).");
        System.out.println("Digite 'sair' para encerrar:");

        while (true) {
            System.out.print("→ ");
            String entrada = sc.nextLine().trim();

            if (entrada.equalsIgnoreCase("sair")) {
                break;
            }

            // Divide a entrada em nome e sexo
            String[] partes = entrada.split(",");
            if (partes.length != 2) {
                System.out.println("Formato inválido! Use: Nome,Sexo (ex: Maria,F)");
                continue;
            }

            String nome = partes[0].trim();
            String sexo = partes[1].trim().toUpperCase();

            pessoas.add(new Pessoa(nome, sexo));
        }

        System.out.println("\n=== Lista completa de pessoas ===");
        pessoas.forEach(p -> System.out.println(p.getNome() + " - " + p.getSexo()));

        // Cria uma nova lista apenas com mulheres usando lambda e if/else
        List<Pessoa> mulheres = pessoas.stream()
                .filter(p -> {
                    if (p.getSexo().equalsIgnoreCase("F")) {
                        return true;
                    } else {
                        return false;
                    }
                })
                .collect(Collectors.toList());

        System.out.println("\n=== Grupo de mulheres ===");
        if (mulheres.isEmpty()) {
            System.out.println("Nenhuma mulher cadastrada.");
        } else {
            mulheres.forEach(p -> System.out.println(p.getNome() + " - " + p.getSexo()));
        }

        sc.close();
    }
}
