package com.sammdiev.demo;

import com.sammdiev.demo.dao.MahasiswaDao;
import com.sammdiev.demo.entity.Mahasiswa;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private MahasiswaDao mahasiswaJdbcTemplate;
	@Test
	public void getAll() {
		Mahasiswa mahasiswa = new Mahasiswa("012301","Sam",3.88F, "TI");
	}
}
