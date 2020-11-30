package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import DAO.PontoTuristicoDAO;
import entidades.PontoTuristico;

@ManagedBean
public class PontoTuristicoBean {
	private PontoTuristico ponto = new PontoTuristico();
	private List<PontoTuristico> lista;

	public String salvar() {
		PontoTuristicoDAO.salvar(ponto);
		ponto = new PontoTuristico();
		return null;
	}

	public String editar() {
		PontoTuristicoDAO.editar(ponto);
		return null;
	}

	public String excluir() {
		lista.remove(ponto);
		PontoTuristicoDAO.excluir(ponto);
		return null;
	}

	public PontoTuristico getPonto() {
		return ponto;
	}

	public void setPonto(PontoTuristico ponto) {
		this.ponto = ponto;
	}

	public List<PontoTuristico> getLista() {
		if (lista == null) {
			lista = PontoTuristicoDAO.listar();
		}
		return lista;
	}

	public void setLista(List<PontoTuristico> lista) {
		this.lista = lista;
	}

}
