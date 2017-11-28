package com.trail.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.trail.sample.pojo.ProfileInfo;
import com.trail.sample.repo.ProfileInfoRepo;


//@RunWith(SpringRunner.class)
/*@SpringBootTest(classes=App.class)
//@AutoConfigureMockMvc(secure=false)
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MainPageController.class)*/
public class MainPageControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	ProfileInfoRepo profileInfoRepo;
	
	ProfileInfo profileInfo = new ProfileInfo(1l, "Peter", "James", "C:\1.jpg", null);
	
	@Autowired
    ObjectMapper objectMapper;
	
//	@Test
//	public void postInfo() throws Exception{
//		profileInfoRepo.save(profileInfo);
//		ProfileInfoRepo findByProfileId = profileInfoRepo.findByProfileId(profileInfo.getProfileId());
//		 		
//	}
	
//	@Test
//	public void indexTest(){
//		 try {
//			mockMvc.perform(MockMvcRequestBuilders.get("/"))
//			 .andExpect(MockMvcResultMatchers.model().hasNoErrors())
//			 .andExpect(MockMvcResultMatchers.model().attributeExists("profileInfo"))
//			 .andExpect(MockMvcResultMatchers.view().name("index"))
//			 .andExpect(MockMvcResultMatchers.status().isOk());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//	 @Test
//	public void postInfoEdit(){
//		 try {
//			mockMvc.perform(post("/postInfo")
//			            .contentType(MediaType.APPLICATION_JSON)
//			            .content(objectMapper.writeValueAsBytes(profileInfo))).andExpect(view().name("index"));
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		            
//	}
	
	
	
	
	
	
}
