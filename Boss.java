package game;

public class Boss extends Personagem{

    public Boss(String name){
        this.name = name;
        this.level = 5;
        specialUnlocked = false;
        hpBase = 60;
        powBase = 18;
        defBase = 7;
        resetStatus();
    }

    @Override
    public void attack(Personagem target) {
        System.out.println(name + " levanta seu machado e ataca " + target.name + "!");
        target.receiveDamage(pow);
    }

    @Override
    public void defend() {
        System.out.println(name + " se protege com seu machado!");
    }

    @Override
    public void useSpecial(Personagem target) {
    }

    @Override
    public void levelUp(){
        resetStatus();
    }

    public void heal(){
        System.out.println(name + " pega uma poção misteriosa dos bolsos e bebe, ele parece mais revigorado!");
        hp = Math.min(hpBase, hp+16);
    }

}