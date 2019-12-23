
import java.util.concurrent.TimeUnit
import kotlin.system.exitProcess


fun kyla(){

    var valinta=0
    var tuopinhinta = (1..3).random()
    try {
        while (valinta < 1) {
hahmo()
            println("1. Taverna, energiat täyteen, tuoppi maksaa $tuopinhinta rahaa")
            println("2. Asekauppaan")
            println("3. Haarniskaputiikki")
            println("4. Peikkometsään")
            valinta = Integer.valueOf(readLine())
            when (valinta) {
                1 -> {
                    println("Tavernaan")
                    valinta = 0
                    taverna(tuopinhinta)
                    hahmo()
                }
                2 -> {
                    println("Asekauppaan")
                    asekauppa()
                }
                3 -> {
                    println("Haarniskakaupoille")
                    haarniskaKauppa()
                }
                4 -> {
                    println("Peikkometsään")
                    liiku=true
                    kartta()

                }
                else -> { println("\nPikkasen liian suuri numero\n")
                    paussi(1)
                valinta = 0}
            }
        }
    }catch(e: NumberFormatException) {
            valinta=0
            println("\nValintasi on virheellinen, voit syöttää vain numeroita")
            paussi(1)
            kyla()}
}

fun taverna(hinta:Int){
    println("Menit tavernaan lepäämään energiat täyteen. Tinttaat energiajuomia niin kauan kun energiat on täydet.")
    var kerta=0
            while (hp < maxhp) {
                var tuoppihp = (5..12).random()
                if (hinta <= raha) {
                    raha=raha-hinta
                    kerta += 1
                    hp=hp+tuoppihp
                    paussi(1)
                    println("Energiat:$hp     Maksimit:$maxhp")
                } else {
                    println("Sinulla ei ole rahaa tankata energioita täyteen. Rahaa jäljellä $raha")
                    break}
                if (hp > maxhp) {
                    hp=maxhp
                    var kokosetti: Int = kerta * hinta
                    paussi(1)
                    println("Energiat on nyt täydet, joit $kerta kertaa ja rahaa meni $kokosetti \n")
                }
            }
    kyla()
}

fun hahmo(){

    if (xp >100 && taso==1 || xp > 499 && taso==2 || xp >1200 && taso==3 || xp > 2000 && taso==4 || xp>3000 && taso==5 || xp>5000 && taso==6 || xp>7000 && taso==7 || xp>9000 && taso==8 || xp>11000 && taso==9){
    maxhp = maxhp + (6..12).random()
    hp=maxhp
    taso=taso+1
    if (taso==10){
    println("")
    println("Olet päässyt tasolle 10. joka on tämän pelin maksimi taso.\n")

    println("")}
    println("")
    println("Taistelukokemuksen myötä huomaat kehittyneesi, Energiasi on nyt: $maxhp\n")
    println("")
    }

    println("|Nimi: $nimi | Raha: $raha || Taso: $taso || kokemus: $xp")
    println("|Panssari: $panssari | Ase: $ase |")
    println("| Suoja: $suoja || Vahinko: $vahinko || Energia: $hp")
    println("")

}
//PAUSSI
fun paussi(aika:Int) {
    TimeUnit.SECONDS.sleep(aika.toLong())
}


//ASEET
fun asenimi(index:Int): String {
    val nimike =
        arrayOf("tikari", "piikkinuija", "lyhytmiekka", "pitkämiekka", "sotakirves", "kahdenkädenmiekka", "tulimiekka")
    var tuote = nimike.get(index)
    return tuote
}
fun asevahinko(index: Int): Int {
    val vahinko = arrayOf(10, 13, 20, 29, 36, 40, 50)
    var tuote = vahinko.get(index)
    return tuote
}
fun asehinta(index:Int):Int {
    val hintaase= arrayOf(10,28,48,70,99,140,350)
    var tuote=hintaase.get(index)
    return tuote
}
// SUOJAT
fun armornimi(index:Int):String {
    val suojanimi = arrayOf("nahkapanssari","ketjuhaarniska","rengashaarniska","rintapanssari","peltihaarniska")
    var tuote = suojanimi.get(index)
    return tuote
}
fun armorsuoja(index:Int):Int {
    val suojaluku = arrayOf(10,15,20,25,35)
    var tuote = suojaluku.get(index)
    return tuote
}
fun armorhinta(index:Int):Int {
    val suojahinta = arrayOf(30,65,190,300,499)
    var tuote = suojahinta.get(index)
    return tuote
}

fun haarniskaKauppa() {
    paussi(1)
    println("Saavuit haarniskakauppaan jossa kauppias odotteleekin kaupantekoa.\n")
    var valinta =0
    try {
        while (valinta ==0) {
            hahmo()
            var index = 0
            val laskuri = 0
            var tuote = ""
            var hinta = 0
            for (i in 0..4) {
                index += 1
                tuote = armornimi(i)
                hinta = armorhinta(i)
                println("$index. $tuote hinta: $hinta")
            }
            println("6. Poistu kaupasta")
            println("\nMitä laitetaan?")
            valinta = Integer.valueOf(readLine())
            when (valinta) {
                in 1..5 -> {
                    val hinta = armorhinta(valinta - 1)
                    if (raha < hinta) {
                        println("\nSinulla ei rahaa ostaa valitsemaasi tuotetta\n\n")
                        valinta = 0
                    } else {
                        raha = raha - hinta
                        panssari = armornimi(valinta - 1)
                        suoja = armorsuoja(valinta - 1)
                        println("\nOstit haarniskan $panssari\n")
                        paussi(1)
                        valinta = 0
                    }
                }
                6 -> kyla()
                else -> {
                    println("\nValintasi on virheellinen")
                    valinta = 0
                }
            }
        }
    }catch(e: NumberFormatException) {
        valinta=0
        println("\nValintasi on virheellinen, voit syöttää vain numeroita")
        paussi(1)
        haarniskaKauppa()}
}

fun asekauppa() {
    paussi(1)
    println("Saavuit asekauppaan jossa seppä hieraisee kätensä mustasta noesta ja kääntyy rintamasuunta sinuun päin valmiina tekemään kauppoja.\n")
    var valinta =0
    try {
    while (valinta ==0) {
        hahmo()
        var index = 0
        val laskuri = 0
        var tuote = ""
        var hinta = 0
        for (i in 0..6) {
            index += 1
            tuote = asenimi(i)
            hinta = asehinta(i)
            println("$index. $tuote hinta: $hinta")
        }
        println("8. Poistu kaupasta")
        println("\nMitä laitetaan?")
        valinta = Integer.valueOf(readLine())
        when (valinta) {
            in 1..7 -> {
                val hinta = asehinta(valinta - 1)
                if (raha < hinta) {
                    println("\nSinulla ei rahaa ostaa valitsemaasi tuotetta\n\n")
                    valinta = 0
                } else {
                    raha = raha - hinta
                    ase = asenimi(valinta - 1)
                    vahinko = asevahinko(valinta - 1)
                    println("\nOstit aseen $ase\n")
                    paussi(1)
                    valinta = 0
                }
            }
            8 -> kyla()
            else -> {
                println("\nValintasi on virheellinen")
                valinta = 0
            }
        }
    }
    }catch(e: NumberFormatException) {
        valinta=0
        println("\nValintasi on virheellinen, voit syöttää vain numeroita")
        paussi(1)
        asekauppa()}
}

fun main(args: Array<String>) {

    print ("Anna sankarille nimi: ")
    nimi= readLine().toString()


    if (nimi=="") {
        nimi = "Urho"
    }

    println("\nOlet saapunut peikkometsänkylään, kylää terrorisoi metsän peikkokansa.\nSinun tehtäväsi on päättää tämä vitsaus josta kyläiset ovat kärsineet jo kauan.\n")



kyla()

}
//Globaalit muuttujat
var nimi: String="DiskoEki"
var panssari ="Paita"
var ase="Nyrkit"
var maxhp :Int = (10..30).random()
var hp = maxhp
var xp=0
var taso=1
var vahinko=3
var suoja=1
var raha = (20..100).random()
var liiku=false
var omax = 0
var omay = 9
var taistelu=false

//Laitetaan alkukartta muistiin
val kartta = arrayOf(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1,3),
    intArrayOf(1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1,3),
    intArrayOf(1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1,3),
    intArrayOf(1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1,3),
    intArrayOf(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1,3),
    intArrayOf(1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1,3),
    intArrayOf(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1,3),
    intArrayOf(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1,3),
    intArrayOf(1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1,3),
    intArrayOf(2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,3),
    intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,3))

fun kartta(){

        print("\n")


    while (liiku==true) {

        val merkit = " ♠@"

        for (rivi in kartta) {
            for (ruutu in rivi) {
                if (ruutu == 3) {
                    println("")
                } else {
                print(merkit[ruutu])}

            }
        }
        hahmo()
        if (omay == 0 && omax == 10){
            println("\nPääsit peikkokuninkaan luokse, valmistaudu taisteluun\n")
            paussi(1)
            var vihu=4
            kohtaaminen(vihu)
        }

        print("\nAnna suunta. wasd\n")
        val suunta = readLine().toString()

        var uusix = omax
        var uusiy = omay

        if (suunta == "w") {
            uusiy = omay - 1
        }

        if (suunta == "s") {
            uusiy = omay + 1
        }

        if (suunta == "a") {
            if(omay == 9 && omax == 0) {
                println("Saavuit Peikkometsän kylään\n")
                paussi(1)
                kyla()
            } else {uusix = omax - 1

            }
        }

        if (suunta == "d") {
            uusix = omax + 1
        }

         if (kartta[uusiy][uusix] == 0) {
             kartta[omay][omax] = 0
             kartta[uusiy][uusix] = 2
             omay = uusiy
             omax = uusix
         }

        var kohtaaminen = (0..10).random()
        //print("\n$kohtaaminen")
        if (kohtaaminen < 4) {
            liiku=false
            when (taso) {
                1 -> { var vihu = (0..1).random()
                    kohtaaminen(vihu)}
                2 -> { var vihu = (0..2).random()
                    kohtaaminen(vihu)}
                in 3..10 -> { var vihu = (0..3).random()
                    kohtaaminen(vihu)}

            }
            }



        }
    }



fun kohtaaminen(vihu:Int) {

    val peikko = arrayOf("metsänpeikko","metsästäjäpeikko","soturipeikko","tappajapeikko","peikkokuningas")
    val kokemus = arrayOf(10,30,60,100,700)
    val peikkovahinko= arrayOf(1.0,1.15,1.3,1.6,1.8)
    val peikkohp= arrayOf((3..20).random(),(7..50).random(),(25..100).random(),(100..300).random(),600)
    val peikkoraha= arrayOf((1..20).random(),(10..40).random(),(20..50).random(),(30..70).random(),(100..200).random(),500)

    var vihutiedot = mapOf(1 to peikko[vihu], 2 to kokemus[vihu], 3 to peikkovahinko[vihu], 4 to peikkohp[vihu], 5 to peikkoraha[vihu])
    taistelu(vihutiedot)

}
fun numeroDouble(anyNumeroksi:Any?): Double {anyNumeroksi.toString().toDouble()
    return anyNumeroksi as Double
}
fun numeroInt(anyNumeroksi:Any?): Int {anyNumeroksi.toString().toInt()
    return anyNumeroksi as Int
}

fun taistelu(vihutiedot:Map<Int, Any>) {
    val peikko = vihutiedot[1]
    val kokemus = numeroInt(vihutiedot[2])
    val peikkovahinko = numeroDouble(vihutiedot[3])
    var peikkohp = numeroInt(vihutiedot[4])
    val peikkoraha = numeroInt(vihutiedot[5])


    var peikkoase = 0
    var peikkosuoja = 0

    when (peikko) {
        "metsänpeikko" -> {
            peikkoase = (0..1).random()
            peikkosuoja = (0..1).random()
        }
        "metsästäjäpeikko" -> {
            peikkoase = (0..1).random()
            peikkosuoja = (0..2).random()
        }
        "soturipeikko" -> {
            peikkoase = (1..4).random()
            peikkosuoja = (1..3).random()
        }
        "tappajapeikko" -> {
            peikkoase = (3..5).random()
            peikkosuoja = (2..4).random()
        }
        "peikkokuningas" -> {
            peikkoase = 6
            peikkosuoja = 4
        }
    }
    var peikkoasenimi = asenimi(peikkoase)
    var peikkoasevahinko = asevahinko(peikkoase)
    var peikkosuojanimi = armornimi(peikkosuoja)
    var peikkosuojaluku = armorsuoja(peikkosuoja)
    if (peikko != "peikkokuningas") {
        println("Metsässä sinua vastaan tulee $peikko\n")
    } else {
        println("Vastassi on peikkokuningas jonka kiiltävä peltihaarniskasta ihanasti kimmeltää tulimiekan loistaessa. Peikkokuningas on valmiina tekemään sinusta itselleen taljan")
    }


    taistelu = true



    var valinta = ""
    try {
        while (taistelu == true) {
            print("|Vastustaja: $peikko | |Aseena: $peikkoasenimi |  |Panssari: $peikkosuojanimi |  Energia: $peikkohp |\n\n")


            hahmo()
            println("\nTaistele t, pakene p")
            valinta = readLine().toString()


            when (valinta) {
                "t" -> {
                    var swing = pelaajalyo()
                    var pelaajavahinko = swing - peikkosuojaluku
                    //println("\nSwing: $swing pelaajavahinko: ${pelaajavahinko.toInt()}, Peikkosuojaluku: $peikkosuojaluku\n")
                    if (pelaajavahinko > 0) {
                        peikkohp = peikkohp - pelaajavahinko.toInt()
                        if (peikkohp < 0) {
                            if (peikko=="peikkokuningas") {loppu()}
                            println("\nPeikko lyhistyy maahan kuolleena, peikosta sait $peikkoraha kolikkoa\n")
                            paussi(1)
                            raha = raha + peikkoraha
                            xp = xp + kokemus
                            taistelu=false
                            liiku=true
                        } else {println("\nTeit peikkon vahinkoa mutta peikko jatkaa vielä taistelua\n")
                        paussi(1)
                            println("Peikko lyö sinua")
                            paussi(1)
                            peikkolyo(peikkovahinko,peikkoasevahinko)
                        }
                    } else {println("\nLyöntisi ei läpäissyt peikon panssaria\n")
                    paussi(1)
                        println("Peikko lyö sinua")
                        paussi(1)
                        peikkolyo(peikkovahinko,peikkoasevahinko)}
                }
                "p" -> {
                        var karkuun = (1..5).random()
                    if (karkuun < 3 ) {
                        println("Et pääse karkuun, peikko lyö sinua.\n")
                        paussi(1)
                        peikkolyo(peikkovahinko,peikkoasevahinko)
                    } else {
                        if (omay == 0 && omax == 10){
                            omay=1
                            omax=10
                        }
                        taistelu=false
                        liiku=true
                    kartta()}
                }
                    else -> println("Valintasi on virheellinen, voit syöttää vain t tai p")
                }
            }
        } catch (e: NumberFormatException) {
            valinta = ""
            println("\nValintasi on virheellinen, voit syöttää vain numeroita")
            paussi(1)
        }

}
fun pelaajalyo() :Double{

    var swing = (0.00)
    swing= (1..100).random().toDouble()
    when (swing) {
       in 1..30 -> println("Lyöntisi on heikko")
        in 31..50 -> println("Lyöntisi on keskivertoa heikompi")
        in 51..70 -> println("Lyöntisi on hyvä")
        in 71..90 -> println("Lyöntisi hipoo täydellisyyttä")
        in 91..100 -> println("Täydellinen lyönti")
    }
    paussi(1)

    swing=(swing/100)+1

    swing = swing.toDouble() * vahinko.toDouble()
    var taso2 =((taso.toDouble()/10)+1)
    swing = swing * taso2

    return swing

}
fun peikkolyo(peikkovahinko:Double, peikkoasevahinko:Int) {
    var swing = (1..100).random().toDouble()
    when (swing) {
        in 1..30 -> println("Peikon lyönti on heikko\n")
        in 31..50 -> println("Peikon lyönti on keskivertoa heikompi\n")
        in 51..70 -> println("Lyönti on hyvä\n")
        in 71..90 -> println("Lyönti hipoo täydellisyyttä\n")
        in 91..100 -> println("Täydellinen lyönti\n")
    }
    paussi(1)
    swing=(swing/100)+1
    swing = swing * peikkoasevahinko
    swing = swing * peikkovahinko

    var lyonti = swing.toInt() - suoja
    if(lyonti > 0){
        hp = hp - lyonti
        println("Sait osuman")
        if (hp < 0) {kuolema()}
    } else {println("Peikon isku ei läpäissyt panssariasi")

    }
    }



fun kuolema(){
    liiku=false
    taistelu=false
    println("\nKuolema korjasi sinut paremmille metsästysmaille")
    paussi(1)
    for(i in 0..30) {
        println("")
    }
    println("Seikkailusi päättyi tähän, sinut on isketty hengiltä. $nimi jäi tasolle: $taso, kokemuspisteitä kerätty: $xp \n")
    paussi(3)
    println("")
    var valinta = readLine().toString()
    exitProcess(-1)
}

fun loppu(){
    println("\n\nPeikkokuningas kaatuu maahan, aiemmin kiiltävä peltihaarniska on veren peitossa. Peikkojen aiheuttama vitsaus on päättynyt samassa.")
    paussi(2)
    println("Sinua juhlitaan monta päivää ja yötä sankarina joka pelasti kylän peikkojen kiroukselta.")
    paussi(5)
    println("")
    var valinta = readLine().toString()
    exitProcess(-1)

}