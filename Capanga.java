package game;

public class Capanga extends Personagem{

    public Capanga(String name){
        this.name = name;
        this.level = 1;
        specialUnlocked = false;
        hpBase = 22;
        powBase = 10;
        defBase = 2;
        resetStatus();
    }

    @Override
    public void attack(Personagem target) {
        System.out.println(name + " pega sua adaga e ataca " + target.name + "!");
        target.receiveDamage(pow);
    }

    @Override
    public void defend() {
        System.out.println(name + " se protege com suas braçadeiras!");
    }

    @Override
    public void useSpecial(Personagem target) {
    }

    @Override
    public void levelUp(){
        resetStatus();
    }
}