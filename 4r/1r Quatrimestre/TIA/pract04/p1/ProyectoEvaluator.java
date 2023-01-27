package proye;

import java.util.ArrayList;

import org.opt4j.core.Objectives;
import org.opt4j.core.Objective.Sign;
import org.opt4j.core.problem.Evaluator;


public class ProyectoEvaluator implements Evaluator<ArrayList<Integer>>{

	@Override
	public Objectives evaluate(ArrayList<Integer> phenotype) {
		
		double beneficioTotal = 0;
		double ramTotal = 0;
		
		for (int i = 0; i < phenotype.size(); i++) { //La i es el numero del proces
			double beneficioProceso = DatosCloud.beneficio[i];
			double ramProceso = DatosCloud.RAM[i];
			int ordenador = phenotype.get(i);
			
			if(ordenador != -1) {
				
				beneficioTotal += beneficioProceso;
				ramTotal += ramProceso;
			} 
		}
		
		Objectives objectives = new Objectives();
		objectives.add("Beneficio: ", Sign.MAX, beneficioTotal);
		objectives.add("Ram: ", Sign.MIN, ramTotal);
		
		return objectives;
	}

}
