package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaProtected {
		
		static final protected int NUMERO_MASSIMO_DIREZIONI = 4;
		static final protected int NUMERO_MASSIMO_ATTREZZI = 10;
		
		protected String nome;
		
		protected Attrezzo[] attrezzi;
		protected int numeroAttrezzi;
	    
		protected Stanza[] stanzeAdiacenti;
		protected int numeroStanzeAdiacenti;
	    
		protected String[] direzioni;
	    
	    /**
	     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	     * @param nome il nome della stanza
	     */
	    public StanzaProtected(String nome) {
	        this.nome = nome;
	        this.numeroStanzeAdiacenti = 0;
	        this.numeroAttrezzi = 0;
	        this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
	        this.stanzeAdiacenti = new Stanza[NUMERO_MASSIMO_DIREZIONI];
	        this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
	    }

	    /**
	     * Imposta una stanza adiacente.
	     *
	     * @param direzione direzione in cui sara' posta la stanza adiacente.
	     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	     */
	    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
	        boolean aggiornato = false;
	    	for(int i=0; i<this.direzioni.length; i++)
	        	if (direzione.equals(this.direzioni[i])) {
	        		this.stanzeAdiacenti[i] = stanza;
	        		aggiornato = true;
	        	}
	    	if (!aggiornato)
	    		if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
	    			this.direzioni[numeroStanzeAdiacenti] = direzione;
	    			this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;
	    		    this.numeroStanzeAdiacenti++;
	    		}
	    }

	    /**
	     * Restituisce la stanza adiacente nella direzione specificata
	     * @param direzione
	     */
		public Stanza getStanzaAdiacente(String direzione) {
	        Stanza stanza = null;
			for(int i=0; i<this.numeroStanzeAdiacenti; i++)
	        	if (this.direzioni[i].equals(direzione))
	        		stanza = this.stanzeAdiacenti[i];
	        return stanza;
		}

	    /**
	     * Restituisce la nome della stanza.
	     * @return il nome della stanza
	     */
	    public String getNome() {
	        return this.nome;
	    }

	    /**
	     * Restituisce la descrizione della stanza.
	     * @return la descrizione della stanza
	     */
	    public String getDescrizione() {
	        return this.toString();
	    }

	    /**
	     * Restituisce la collezione di attrezzi presenti nella stanza.
	     * @return la collezione di attrezzi nella stanza.
	     */
	    public Attrezzo[] getAttrezzi() {
	        return this.attrezzi;
	    }

	    /**
	     * Mette un attrezzo nella stanza.
	     * @param attrezzo l'attrezzo da mettere nella stanza.
	     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	     */
	    public boolean addAttrezzo(Attrezzo attrezzo) {
	        if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
	        	this.attrezzi[numeroAttrezzi] = attrezzo;
	        	this.numeroAttrezzi++;
	        	return true;
	        }
	        else {
	        	return false;
	        }
	    }
	    public int getNumeroAttrezzi() {
	    	return numeroAttrezzi;
	    }
	   /**
		* Restituisce una rappresentazione stringa di questa stanza,
		* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
		* @return la rappresentazione stringa
		*/
	    public String toString() {
	    	StringBuilder risultato = new StringBuilder();
	    	risultato.append(this.nome);
	    	risultato.append("\nUscite: ");
	    	for (String direzione : this.direzioni) {
	    		if (direzione!=null)
	    			risultato.append(" " + direzione);
	    	}
	    	risultato.append("\nAttrezzi nella stanza: ");
	    	
	    	for(int i = 0; i<this.numeroAttrezzi; i++) {
	    		Attrezzo attrezzo = this.attrezzi[i];
	    		if(attrezzo != null)
	    			risultato.append(attrezzo.toString()+" ");
	    	}
	    	return risultato.toString();
	    }

	    /**
		* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
		* @return true se l'attrezzo esiste nella stanza, false altrimenti.
		*/
		public boolean hasAttrezzo(String nomeAttrezzo) {
			boolean trovato;
			trovato = false;
			for (Attrezzo attrezzo : this.attrezzi) {
				if (attrezzo.getNome().equals(nomeAttrezzo))
					trovato = true;
			}
			return trovato;
		}

		/**
	     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
		 * @param nomeAttrezzo
		 * @return l'attrezzo presente nella stanza.
	     * 		   null se l'attrezzo non e' presente.
		 */
		public Attrezzo getAttrezzo(String nomeAttrezzo) {
			Attrezzo attrezzoCercato;
			attrezzoCercato = null;
			for (int i = 0; i<this.numeroAttrezzi; i++) {
				Attrezzo attrezzo = this.attrezzi[i]; //Dichiaro attrezzo e scorro gli attrezzi della stanza salvati nell'array
				if (attrezzo.getNome().equals(nomeAttrezzo))
					attrezzoCercato = attrezzo;
			}
			return attrezzoCercato;	
		}

		/**
		 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
		 * @param nomeAttrezzo
		 * @return true se l'attrezzo e' stato rimosso, false altrimenti
		 */
		public boolean removeAttrezzo(Attrezzo attrezzo) {
			if(attrezzo == null) return false;
			//dopo che rimuovo l'attrezzo riduco il numero attrezzi e sposto
			//tutti gli attrezzi successivi al posto precedente in Attrezzo[]
			
			for(int j = 0; j<this.numeroAttrezzi; j++) {
				if(this.attrezzi[j] == attrezzo) {
					for(int i=j; i<this.numeroAttrezzi-1; i++) {
						this.attrezzi[i] = this.attrezzi[i+1];
					}
				}
			}
			this.attrezzi[this.numeroAttrezzi - 1] = null; 	//Ho spostato gli attrezzi indietro e gli ultimi due sono uguali. Setto l'ultimo a null
			this.numeroAttrezzi--; 							//levando un attrezzo decremento il numero totale
			return true;
		}


		public String[] getDirezioni() {
			String[] direzioni = new String[this.numeroStanzeAdiacenti];
		    for(int i=0; i<this.numeroStanzeAdiacenti; i++)
		    	direzioni[i] = this.direzioni[i];
		    return direzioni;
	    }

	
}
