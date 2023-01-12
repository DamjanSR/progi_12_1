package CrnePatike.globerunner_be.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "borba")
public class Borba {
    @Id
    @Column(name = "id")
    private UUID id; // jedinstveni identifikator borbe
    @Column(name = "initiator")
    private String initiatorUsername; // korisnicko ime igraca koji je predlozio/zapoceo borbu
    @Column(name = "opponent")
    private String opponentUsername; // korisnicko ime igraca koji je prihvatio borbu
    @Column(name = "winner")
    private String winner; // korisnicko ime igraca koji je pobjedio
    @Column(name = "loser")
    private String loser; // korisnicko ime igraca koji je izgubio

    public Borba() {
    }

    public Borba(UUID id, String initiatorUsername, String opponentUsername, String winner, String loser) {
        this.id = id;
        this.initiatorUsername = initiatorUsername;
        this.opponentUsername = opponentUsername;
        this.winner = winner;
        this.loser = loser;
    }

    public UUID getId() {
        return id;
    }

    public String getInitiatorUsername() {
        return initiatorUsername;
    }

    public String getOpponentUsername() {
        return opponentUsername;
    }

    public String getWinner() {
        return winner;
    }

    public String getLoser() {
        return loser;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setInitiatorUsername(String initiatorUsername) {
        this.initiatorUsername = initiatorUsername;
    }

    public void setOpponentUsername(String opponentUsername) {
        this.opponentUsername = opponentUsername;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void setLoser(String loser) {
        this.loser = loser;
    }
}
