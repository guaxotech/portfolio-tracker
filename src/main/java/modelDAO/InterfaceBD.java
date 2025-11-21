/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelDAO;

/**
 *
 * @author vinic
 * Essa classe define um contrato (conjunto comum de métodos) para toda a 
 * camada de persistência
 */
public interface InterfaceBD {
    public boolean conexaoAberta();
    public void fecharConexao();
    public Object find(Class c, Object id) throws Exception;
    public void persist(Object o) throws Exception; // persist -> salvar
    public void remover(Object o) throws Exception;
}
