package com.Grupo10OO22022.services;
import java.util.List;

import com.Grupo10OO22022.entities.Degree;
import com.Grupo10OO22022.models.DegreeModel;




public interface IDegreeService {

	public List<Degree> getAll();
	
	public DegreeModel insertOrUpdate(DegreeModel degreeModel);
	
	public boolean remove(int id);
}

