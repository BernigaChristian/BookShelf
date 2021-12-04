package me.berniga;

public class Scaffale {
// Attributi
	private static final int NUM_RIPIANI=5;
	private Mensola ripiani[];
// Costruttori
	public Scaffale() {
		int ripiano;
		ripiani=new Mensola[NUM_RIPIANI];
		for (ripiano=0; ripiano<NUM_RIPIANI; ripiano++)
			ripiani[ripiano]=new Mensola();
	}
	public Scaffale(Scaffale scaffale) throws PosizioneNonValida {
		int ripiano, posizione;
		Libro libro;
		ripiani=new Mensola[NUM_RIPIANI];
		for (ripiano=0; ripiano<NUM_RIPIANI; ripiano++) {
			ripiani[ripiano]=new Mensola();
			for ( posizione=0; posizione<ripiani[ripiano].getNumMaxVolumi();ripiano++) {
				libro=scaffale.getLibro(ripiano, posizione);
				if (libro!=null)
					ripiani[ripiano].setVolume(libro, posizione);
			}
		}
	}
// Metodi
	public Libro getLibro(int ripiano, int posizione) throws PosizioneNonValida {
		try {
			return ripiani[ripiano].getVolume(posizione);
		}
		catch (ArrayIndexOutOfBoundsException exception) {
			throw new PosizioneNonValida(posizione, ripiano);
		}
	}
	public void setLibro(Libro libro, int ripiano, int posizione) throws PosizioneNonValida, PosizioneNonVuota {
		int err;
		try {err = ripiani[ripiano].setVolume(libro, posizione);
		if (err <0)
			if (err ==-1)
				throw new PosizioneNonValida(posizione, ripiano);
			else
				throw new PosizioneNonVuota(posizione, ripiano);
		}	
		catch (ArrayIndexOutOfBoundsException exception) {
			throw new PosizioneNonValida(posizione, ripiano);
		}
	}
	public void rimuoviLibro(int ripiano, int posizione) throws PosizioneNonValida {
		try {
			if (ripiani[ripiano].rimuoviVolume(posizione)<0)
				throw new PosizioneNonValida(posizione, ripiano);
		}
		catch (ArrayIndexOutOfBoundsException exception) {
			throw new PosizioneNonValida(posizione, ripiano);
		}
	}
	public static int getNumRipiani() {
		return NUM_RIPIANI;
	}
	public int getNumMaxLibri() {
		int ripiano, n=0;
		for (ripiano=0; ripiano<NUM_RIPIANI; ripiano++) {
			n += ripiani[ripiano].getNumMaxVolumi();
		}
		return n;
	}
	public int getNumLibri() {
		int ripiano, n=0;
		for (ripiano=0; ripiano<NUM_RIPIANI; ripiano++) {
			n += ripiani[ripiano].getNumVolumi();
		}
		return n;
	}
	public int getNumLibri(int ripiano) throws PosizioneNonValida {
		try {
			return ripiani[ripiano].getNumVolumi();
		}
		catch (ArrayIndexOutOfBoundsException exception) {
			throw new PosizioneNonValida(0, ripiano);
		}
	}
}