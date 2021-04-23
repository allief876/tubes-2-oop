package tubes;

import java.util.ArrayList;

public class Pikachu extends Engimon {
    public Pikachu(String name, Coordinate pos, int level) {
        super(name, "Pikachu", "Electric", "none", "Yuk bisa yuk", pos, level);
        ArrayList<String> element =  new ArrayList<String>();
        element.add("Electric"); element.add("none");
        Elements.addAll(element);
        Skill newSkill = new Skill(element,125,1,"Thunderbolt");
        this.incSkills(newSkill);
    }
}