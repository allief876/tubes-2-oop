package tubes;

import java.util.ArrayList;

public class Charmander extends Engimon {
    public Charmander(String name, Coordinate pos, int level) {
        super(name, "Charmander", "Fire", "none", "Ada tubes 3 gak?", pos, level);
        ArrayList<String> element =  new ArrayList<String>();
        element.add("Fire"); element.add("none");
        Elements.addAll(element);
        Skill newSkill = new Skill(element,105,1,"Pyro Ball");
        this.incSkills(newSkill);
    }
}
