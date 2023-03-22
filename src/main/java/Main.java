import domain.Advogado;
import domain.Estado;
import domain.Processo;
import domain.TipoDeAcao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
        EntityManager entityManager = factory.createEntityManager();

        TipoDeAcao tp_acao = new TipoDeAcao();
        tp_acao.setNome("CIVIL");

        Estado est = new Estado();
        est.setNome("SAO PAULO").setSigla("SP");

        Advogado adv = new Advogado();
        adv.setNome("RAFAEL").setNumeroOAB("777").setEstado(est);

        Processo proc = new Processo();
        proc.setNumero("123456").setDataDeDistribuicao(LocalDate.now()).setAdvogado(adv).setTipoDeAcao(tp_acao).setProBono(true);

        entityManager.getTransaction().begin();

//        entityManager.persist(tp_acao);
//        entityManager.persist(est);
//        entityManager.persist(adv);
//        entityManager.persist(proc);

        entityManager.getTransaction().commit();

        // Consulta o processo pelo identificador
        String id = "1";
        Processo processoConsultado = consultarProcesso(entityManager, id);
        System.out.println("Processo consultado: " + processoConsultado);

        // Consulta todos os processos
        List<Processo> processos = consultarTodosProcessos(entityManager);
        System.out.println("Processos consultados: " + processos);

        entityManager.close();
    }

    public static Processo consultarProcesso(EntityManager entityManager, String id) {
        return entityManager.find(Processo.class, id);
    }

    public static List<Processo> consultarTodosProcessos(EntityManager entityManager) {
        String jpql = "SELECT p FROM Processo p";
        TypedQuery<Processo> query = entityManager.createQuery(jpql, Processo.class);
        return query.getResultList();
    }


}
