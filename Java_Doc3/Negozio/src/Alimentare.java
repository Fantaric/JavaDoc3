import java.util.*;

/**
 * La classe gestisce la tipologia Alimentare di Prodotto
 * @author Riccardo
 */
public class Alimentare extends Prodotto {
    
    /**
     * anno di scadenza riportato sulla confezione del prodotto
     */
    protected int annoScadenza;
    /**
     * mese di scadenza riportato sulla confezione del prodotto
     */
    protected int meseScadenza;

    /**
     * Costruttore Parametrico - Costruisce un oggetto di tipo ProdottoAlimentare
     * @param annoScadenza mese di scadenza da assegnare al nuovo oggetto Prodotto
     * @param meseScadenza anno di scadenza da assegnare al nuovo oggetto Prodotto
     * @param nome nome da assegnare al nuovo oggetto Prodotto
     * @param prezzo prezzo da assegnare al nuovo oggetto Prodotto
     * @param provenienza nazione di produzione del nuovo oggetto Prodotto
     */
    public Alimentare(int annoScadenza, int meseScadenza, String nome, double prezzo, String provenienza) 
    {
        super(nome, prezzo, provenienza);
        this.annoScadenza = annoScadenza;
        this.meseScadenza = meseScadenza;
    }

    /**
     * Controlla la scadenza del prodotto
     * @return true se il prodotto è scaduto, false altrimenti
     */
    public boolean isScaduto()
    {
        Calendar cal = new GregorianCalendar();
        int anno = cal.get(cal.YEAR);
        int mese = cal.get(cal.MONTH) + 1;

        if (getAnnoScadenza() == anno)
        {
            if(getMeseScadenza() < mese)
                return true;
            else 
                return false;
        }
        else if(getAnnoScadenza() < anno)
            return true;
        else 
            return false;
    }

    /**
     * Applica uno sconto sul prezzo del prodotto Alimentare. 
        <ul>
        <li> Se il prodotto è scaduto lo sconto non viene applicato. </li>
        <li> Se ci si trova nel mese di scadenza allora applica uno sconto del 50% </li>
        <li> Negli altri casi rimane lo sconto del 10%</li>
        </ul>
     */
    public void applicaSconto()
    {
        Calendar cal = new GregorianCalendar();
        int mese = cal.get(cal.MONTH) + 1;
        int anno = cal.get(cal.YEAR);

        if (!isScaduto())
        {
            if (getMeseScadenza() == mese && getAnnoScadenza() == anno)
            {
                setPrezzo(prezzo /2);
            }
            else 
                super.applicaSconto();
        }
    }


    /**
     * Restituisce l'anno di scadenza riportato sulla confezione
     * @return anno di scadenza
     */
    public int getAnnoScadenza() {
        return this.annoScadenza;
    }
    
    /**
     * Imposta l'anno di scadenza dell'oggetto Prodotto Alimentare
     * @param annoScadenza intero che rappresenta l'anno (>1900)
     */
    public void setAnnoScadenza(int annoScadenza) {
        this.annoScadenza = annoScadenza;
    }
    /**
     * anno di scadenza
     * @return annoScadenza anno di scadenza
     */
    public int getMeseScadenza() {
        return this.meseScadenza;
    }
    /**
     * Imposta il mese di scadenza dell'oggetto Prodotto Alimentare
     * @param meseScadenza intero che rappresenta il mese (1-12)
     */
    public void setMeseScadenza(int meseScadenza) {
        this.meseScadenza = meseScadenza;
    }


    @Override
    /**
     * Restituisce una stringa che rappresenta l'oggetto ProdottoAlimentare
     * @return Rappresentazione testuale dell'oggetto ProdottoAlimentare
     */
    public String toString() {
        return "{" +
            " annoScadenza='" + getAnnoScadenza() + "'" +
            ", meseScadenza='" + getMeseScadenza() + "'" +
            "}";
    }


}
