package Entities;

import Enums.Funcao;
import java.util.Date;
import java.util.UUID;
import javax.persistence.*;
import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name = "usuario")

public class Usuario {
    @Id
    @Column(name = "id", columnDefinition = "UUID")
    private UUID id;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "email", unique = true)
    private String email;
    
    @Column(name = "senhaHash")
    private String senhaHash;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "funcao")
    private Funcao funcaoUsuario;
    
    @Column(name = "dataCriacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    
    
    public Usuario(){};

    public Usuario(String nome, String email, String senha, Funcao funcaoUsuario) {
        this.nome = nome;
        this.email = email;
        this.funcaoUsuario = funcaoUsuario;
        this.senhaHash = BCrypt.hashpw(senha, BCrypt.gensalt());
        
        this.id = UUID.randomUUID();
        this.dataCriacao = new Date();
    }
    
    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public Funcao getFuncaoUsuario() {
        return funcaoUsuario;
    }
    
    
    
}
