package pt.ipca.justintime.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.ipca.justintime.domain.Project;
import pt.ipca.justintime.repositories.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepository; 
	
	
	public Project saveProject(Project project) {
        return projectRepository.save(project);
    }
	
	public Project getProjectById(Long id){	
		return projectRepository.findOne(id);
	}
	
	public List<Project> getAllProjects(){
		return projectRepository.findAll();
		
	}
	public void updateProject(Project project){
		projectRepository.saveAndFlush(project);
		
	}
	public void deleteProject(Long id){
		projectRepository.delete(id);
	}

}
