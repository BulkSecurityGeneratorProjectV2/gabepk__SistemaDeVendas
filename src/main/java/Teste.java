import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.vendas.model.Cliente;
import com.vendas.model.Endereco;
import com.vendas.model.TipoPessoa;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PedidoPU");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin(); {
			Cliente cliente = new Cliente();
			cliente.setNome("João");
			cliente.setEmail("@.");
			cliente.setDocumentoReceitaFederal("doc");
			cliente.setTipo(TipoPessoa.FISICA);
			
			Endereco endereco = new Endereco();
			endereco.setLogradouro("Rua das Aboboras Vermelhas");
			endereco.setNumero("111");
			endereco.setCidade("Uberlândia");
			endereco.setUf("MG");
			endereco.setCep("38400-000");
			endereco.setCliente(cliente);
			
			cliente.getEnderecos().add(endereco);
			
			manager.persist(cliente);
		}
		transaction.commit();
	}
	
}
