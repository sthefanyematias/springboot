package br.senac.sp.guiarestaurante.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Restaurante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Column(unique = true)
	private String cnpj;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String telefone;
	private String horarioFunc;
	@ManyToOne
	private TipoRestaurante tipo;
	private Preco preco;
	private FormasPagamento[] pagamento;
	private Servico[] servicos;
	private String foto;
	@OneToMany(mappedBy = "restaurante")
	private List<Avaliacao> avaliacoes;
	@OneToMany(mappedBy = "restaurante")
	private List<PratoDestaque> destaques;
}
