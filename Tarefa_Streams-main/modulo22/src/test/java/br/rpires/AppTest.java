

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;
import br.rpires.Pessoa;
class AppTest {

    @Test
    void testGrupoDeMulheresContemApenasMulheres() {
        // Lista simulada
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Ana", "F"));
        pessoas.add(new Pessoa("Maria", "F"));
        pessoas.add(new Pessoa("João", "M"));
        pessoas.add(new Pessoa("Carla", "F"));
        pessoas.add(new Pessoa("Pedro", "M"));

        // Filtra apenas mulheres
        List<Pessoa> mulheres = pessoas.stream()
                .filter(p -> p.getSexo().equalsIgnoreCase("F"))
                .collect(Collectors.toList());

        // Verifica se todas as pessoas da lista têm sexo "F"
        assertTrue(
                mulheres.stream().allMatch(p -> p.getSexo().equalsIgnoreCase("F")),
                "O grupo de mulheres contém alguém que não é mulher!"
        );
    }
}
