package mp5;

import java.util.ArrayList;

public class SuperHero {
	private final String superHeroName;
	private final String secretIdentity;
	private ArrayList<ComicBook> appearances = new ArrayList<ComicBook>();
	
	public SuperHero(String superHeroName, String secretIdentity) {
		this.superHeroName = superHeroName;
		this.secretIdentity = secretIdentity;
	}
	
	public void addAppearance(ComicBook comicbook) {
		if ( !appearances.contains(comicbook) ){
			appearances.add(comicbook);
		}
	}
	
	public String getSuperHeroName() {
		return superHeroName;
	}
	public String getSecretIdentity() {
		return secretIdentity;
	}
	
	@Overrides
	public boolean equals(Object other) {
		if (other instanceof SuperHero){
			SuperHero newSuperHero = (SuperHero) other;
			//check if the superhero is the same by checking their names.
			if ( this.getSuperHeroName().equals(newSuperHero.getSuperHeroName()) && 
					this.getSecretIdentity().equals(newSuperHero.getSecretIdentity()) ){
				return true;
			}
		}
		return false; 
	}
}
