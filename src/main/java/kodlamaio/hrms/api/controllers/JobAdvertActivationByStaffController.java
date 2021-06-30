package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertActivationByStaffService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concreates.JobAdvertActivationByStaff;

@RestController
@RequestMapping("/api/jobAdvertActivationByStaff")
@CrossOrigin
public class JobAdvertActivationByStaffController {

		private JobAdvertActivationByStaffService jobAdvertActivationByStaffService;

		@Autowired
		public JobAdvertActivationByStaffController(JobAdvertActivationByStaffService jobAdvertActivationByStaffService) {
			super();
			this.jobAdvertActivationByStaffService = jobAdvertActivationByStaffService;
		}

		@GetMapping("/getall")
		public DataResult<List<JobAdvertActivationByStaff>> getAll(){
			return this.jobAdvertActivationByStaffService.getAll();
			}

		@PostMapping("/approvalJobAdvertByStaff")
		public Result approvalJobAdvertByStaff(@RequestParam int jobAdvertId, @RequestParam int staffId){
			return this.jobAdvertActivationByStaffService.approvalJobAdvertByStaff(jobAdvertId, staffId);
			}
}
