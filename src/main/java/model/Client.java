package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.restlet.ext.oauth.GrantType;
import org.restlet.ext.oauth.ResponseType;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Entity
public class Client implements org.restlet.ext.oauth.internal.Client {

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private String clientId;

    @Column(name = "SECRET", unique = true, nullable = false)
    private char[] clientSecret;

    @Column(name = "TYPE", nullable = false)
    private Client.ClientType clientType;

    @Transient
    private Map<String, Object> properties;

    @Column(name = "PROPERTIES", nullable = false)
    private String propertiesJson;

    @Column(name = "REDIRECT_URI", nullable = false)
    @ElementCollection()
    @CollectionTable(name = "CLIENT_REDIRECT_URIS", joinColumns = @JoinColumn(name = "CLIENT_ID"))
    private List<String> redirectUrisList;

    @Transient
    private String[] redirectUris;

    public Client(String clientId, char[] clientSecret, ClientType clientType,
                  String[] redirectUris, Map<String, Object> properties) throws JsonProcessingException {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.clientType = clientType;
        this.properties = properties;
        this.propertiesJson = new ObjectMapper().writeValueAsString(properties);
        this.redirectUris = redirectUris;
        this.redirectUrisList = new ArrayList<String>();
    }

    public Client() {
    }

    @Override
    public String getClientId() {
        return this.clientId;
    }

    @Override
    public char[] getClientSecret() {
        return this.clientSecret;
    }

    @Override
    public ClientType getClientType() {
        return this.clientType;
    }

    @Override
    public Map<String, Object> getProperties() {
        return this.properties;
    }

    public String getPropertiesJson() {
        return this.propertiesJson;
    }

    public boolean convertProperties() {
        return true;
    }

    public boolean convertRedirectUris() {
        return true;
    }

    @Override
    public String[] getRedirectURIs() {
        return this.redirectUris;
    }

    @Override
    public boolean isGrantTypeAllowed(GrantType grantType) {
        return this.isFlowSupported(grantType);
    }

    @Override
    public boolean isResponseTypeAllowed(ResponseType responseType) {
        return this.isFlowSupported(responseType);
    }

    private boolean isFlowSupported(Object flow) {
        return true;
    }

}
