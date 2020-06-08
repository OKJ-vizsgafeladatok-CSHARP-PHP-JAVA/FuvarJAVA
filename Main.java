import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Main {

	public static List<Fuvar> beolvas() {
		List<Fuvar> lista = new ArrayList<Fuvar>();
		try {
			List<String> sorok = Files.readAllLines(Paths.get("fuvar.csv"));
			for (String sor : sorok.subList(1, sorok.size())) {
				String[] split = sor.split(";");
				Fuvar o = new Fuvar(Integer.parseInt(split[0]),
						LocalDateTime.parse(split[1], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
						Integer.parseInt(split[2]), Double.parseDouble(split[3].replace(",", ".")),
						Double.parseDouble(split[4].replace(",", ".")), Double.parseDouble(split[5].replace(",", ".")),
						split[6]);
				lista.add(o);
			}
		} catch (Exception e) {
			System.out.println("hiba a beolvasásnál. " + e);
		}
		return lista;
	}

	public static void main(String[] args) throws IOException {
		List<Fuvar> a = beolvas();
		System.out.println("3. feladat: " + a.size() + " fuvar");

		// 4. feladat:

		int fuvarSzamlalo = 0;
		double bev = 0.0;
		for (Fuvar f : a) {
			if (f.getId() == 6185) {
				fuvarSzamlalo++;
				bev += f.fuvarBevetele();
			}
		}
		System.out.println("4. feladat: " + fuvarSzamlalo + " fuvar alatt: " + bev + "$");
		// 5. feladat:
		HashMap<String, Integer> stat = new HashMap<String, Integer>();
		for (Fuvar f : a) {
			stat.merge(f.getFizetes_modja(), 1, Integer::sum);
		}
		for (Entry<String, Integer> r : stat.entrySet()) {
			System.out.println("\t" + r.getKey() + ": " + r.getValue());
		}

		// 6. feladat:
		double osszTav = 0.0;
		for (Fuvar f : a) {
			osszTav += f.getTavolsag();
		}
		System.out.println(
				"6. feladat: " + new DecimalFormat("0.00").format(osszTav * 1.6).toString().replace(".", ",") + " km");

		// 7. feladat:
		int max = Integer.MIN_VALUE;
		Fuvar maxF = null;
		for (Fuvar f : a) {
			if (f.getUtazas_idotartam() > max) {
				max = f.getUtazas_idotartam();
				maxF = f;
			}
		}
		System.out.println("7. feladat: Leghosszabb fuvar:");
		System.out.println("\tFuvar hossza:" + maxF.getUtazas_idotartam() + " másodperc");
		System.out.println("\tTaxi azonosító:" + maxF.getId());
		System.out.println("\tMegtett távolság:"
				+ new DecimalFormat("0.0").format(maxF.getTavolsag() * 1.6).toString().replace(".", ",") + " km"); // a
																													// feladatkiírás
																													// nem
																													// számol
																													// az
																													// 1,6
																													// váltószámmal.
		System.out.println("\tViteldíj:" + maxF.getViteldij() + "$");

		// 8.feladat
		String fajlba = "﻿taxi_id;indulas;idotartam;tavolsag;viteldij;borravalo;fizetes_modja\n";
		for (Fuvar f : a) {
			if (f.getUtazas_idotartam() > 0 && f.getViteldij() > 0 && f.getTavolsag() == 0) {
				fajlba += f.getId() + ";"
						+ f.getInd().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
						+ f.getUtazas_idotartam() + ";" + f.getTavolsag() + ";" + f.getViteldij() + ";"
						+ f.getBorravalo() + ";" + f.getFizetes_modja() + "\n";
			}
		}

		Files.write(Paths.get("hibak.txt"), fajlba.getBytes());
		System.out.println("8. feladat: hibak.txt");

	}// end of main

}
