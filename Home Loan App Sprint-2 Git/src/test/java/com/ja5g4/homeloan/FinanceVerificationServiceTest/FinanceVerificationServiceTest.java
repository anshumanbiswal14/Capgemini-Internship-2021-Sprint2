package com.ja5g4.homeloan.FinanceVerificationServiceTest;

import org.junit.jupiter.api.BeforeAll;  
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ja5g4.homeloan.entities.FinanceVerificationOfficer;
import com.ja5g4.homeloan.repository.IFinanceVerificationRepository;
import com.ja5g4.homeloan.service.IFinanceVerificationService;

/* Finance Verification Service JUnit Testing
 * 
 * @Author : Gaurav Srivatsava
 * */

@SpringBootTest
class FinanceVerificationServiceTest {

	public static FinanceVerificationOfficer financeVerificationOfficer;

	@BeforeAll
	public static void setUp() {
		financeVerificationOfficer = new FinanceVerificationOfficer();
	}

	@Autowired
	IFinanceVerificationService finaceVerificationService;

	@MockBean
	IFinanceVerificationRepository financeVerificationRepository;

	@Test
	@DisplayName("Test case for Validate FinanceVerificationOfficer with correct details")
	void testValidAdminPositive() {
		when(financeVerificationRepository.findByUsernameAndPassword("aman@123", "12345")).thenReturn(financeVerificationOfficer);
		boolean val = finaceVerificationService.isValidFinanceOfficer("aman@123", "12345");
		assertEquals(val, true);
	}

	@Test
	@DisplayName("Test case for Validate FinanceVerificationOfficers with wrong details")
	void testValidAdminNegative() {
		when(financeVerificationRepository.findByUsernameAndPassword("aman@123", "12345")).thenReturn(financeVerificationOfficer);
		boolean val = finaceVerificationService.isValidFinanceOfficer("aman@123", "123");
		assertNotEquals(val, true);
	}
}
//By Gaurav Srivatsava