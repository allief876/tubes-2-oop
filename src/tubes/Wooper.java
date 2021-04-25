package tubes;

import java.util.ArrayList;

public class Wooper extends Engimon {
    public Wooper(String name, Coordinate pos, int level, Boolean isWildEngimon) {
        super(name, "Wooper", "Water", "Ground", "Kapan libur...", pos, level, isWildEngimon);
        ArrayList<String> element =  new ArrayList<String>();
        element.add("Water"); element.add("Ground");
        //Elements.addAll(element);
        Skill newSkill = new Skill(element,75,1,"Crystalize");
        this.incSkills(newSkill);
    }
}