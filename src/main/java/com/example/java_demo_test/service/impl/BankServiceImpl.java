package com.example.java_demo_test.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.repository.BankDao;
import com.example.java_demo_test.service.ifs.BankService;
import com.example.java_demo_test.vo.request.BankRequest;
import com.example.java_demo_test.vo.request.BankUpdateRequest;
import com.example.java_demo_test.vo.response.BankResponse;

@Service
public class BankServiceImpl implements BankService {
	Bank bank = new Bank("ABC", "123", 1000);

	@Autowired
	private BankDao bankDao;

	@Transactional
	@Override
	public BankResponse getAmount(BankRequest bankRequest) {
		// 判斷字串不為null且長度不為0
		// StringUtils.hasText(null);

		// 撈DB確認資料(帳號,密碼)
		// 確認完DB再去撈資料
		if (bankRequest.getAccount().equals(bank.getAccount()) && bankRequest.getPwd().equals(bank.getPwd())) {
			return new BankResponse(bankRequest.getAccount(), bank.getAmount(), "成功!");
		}
		return new BankResponse(bankRequest.getAccount(), null, "錯誤!");
	}

//	@Transactional
//	@Override
//	public BankResponse deposit(BankRequest bankRequest) {
//
//		Bank bank = new Bank("ABC", "123", 1000);
//		if (bankRequest.getAccount().equals(bank.getAccount()) && bankRequest.getPwd().equals(bank.getPwd())) {
//
//			if (bankRequest.getAmount() > 0) {
//				System.out.println("存款金額: " + bankRequest.getAmount());
//				bank.setAmount(bank.getAmount() + bankRequest.getAmount());
//				return new BankResponse(bankRequest.getAccount(), bankRequest.getAmount(), bank.getAmount(), "成功!");
//			}
//			return new BankResponse(bankRequest.getAccount(), null, "輸入正確存款金額");
//		}
//		return new BankResponse(bankRequest.getAccount(), null, "錯誤!");
//	}

//	@Override
//	public BankResponse withdraw(BankRequest bankRequest) {
//
//		Bank bank = new Bank("ABC", "123", 1000);
//		if (bankRequest.getAccount().equals(bank.getAccount()) && bankRequest.getPwd().equals(bank.getPwd())) {
//
//			if (bankRequest.getAmount() < bank.getAmount() && bankRequest.getAmount() > 0) {
//				System.out.println("提款金額: " + bankRequest.getAmount());
//				bank.setAmount(bank.getAmount() - bankRequest.getAmount());
//				return new BankResponse(bankRequest.getAccount(), bankRequest.getAmount(), bank.getAmount(), "成功!");
//			}
//			return new BankResponse(bankRequest.getAccount(), null, "輸入正確提款金額!");
//		}
//		return new BankResponse(bankRequest.getAccount(), null, "錯誤!");
//	}

	private boolean checkAccountAndPassword(BankRequest bankRequest, Bank bank) {
		boolean checkResult = bankRequest.getAccount().equals(bank.getAccount())
				&& bankRequest.getPwd().equals(bank.getPwd());
		return checkResult;
	}

	@Transactional
	@Override
	public BankResponse withdraw(BankRequest bankRequest) {
		return depositOrWithdraw(bankRequest, true);
	}

	@Transactional
	@Override
	public BankResponse deposit(BankRequest bankRequest) {
		return depositOrWithdraw(bankRequest, false);
	}

	// 方法名稱中isWithdraw 判斷提款或存款
	// true == 提款
	// false == 存款
	public BankResponse depositOrWithdraw(BankRequest bankRequest, boolean isWithdraw) {
		if (bankRequest.getAccount().equals(bank.getAccount()) && bankRequest.getPwd().equals(bank.getPwd())) {

			if (bankRequest.getAmount() <= 0) {
				return new BankResponse(bankRequest.getAccount(), null, "輸入正確金額!");
			}
			if (isWithdraw && bankRequest.getAmount() < bank.getAmount()) {
				System.out.println("提款金額: " + bankRequest.getAmount());
				bank.setAmount(bank.getAmount() - bankRequest.getAmount());
				return new BankResponse(bankRequest.getAccount(), bankRequest.getAmount(), bank.getAmount(), "提款成功!");
			} else {
				System.out.println("存款金額: " + bankRequest.getAmount());
				bank.setAmount(bank.getAmount() + bankRequest.getAmount());
				return new BankResponse(bankRequest.getAccount(), bankRequest.getAmount(), bank.getAmount(), "存款成功!");
			}
		}
		return new BankResponse(bankRequest.getAccount(), null, "輸入正確帳號!");
	}

	@Transactional
	@Override
	public BankResponse addAccount(BankRequest bankRequest) {
		String reqAccount = bankRequest.getAccount();
		if (!StringUtils.hasText(reqAccount) || !StringUtils.hasText(bankRequest.getPwd())) {
			return new BankResponse(reqAccount, "帳號密碼不得為空");
		}
		if (bankDao.existsById(reqAccount)) {
			return new BankResponse(reqAccount, "帳號已存在");
		}
		Bank bank = new Bank(reqAccount, bankRequest.getPwd());
		Bank result = bankDao.save(bank);
		if (StringUtils.hasText(result.getAccount())) {
			return new BankResponse(result.getAccount(), "新增帳號成功");
		}
		return new BankResponse(result.getAccount(), "新增帳號失敗");
	}

	@Transactional
	@Override
	public BankResponse update(BankUpdateRequest bankUpdateRequest) {
		String reqAccount = bankUpdateRequest.getAccount();
		Optional<Bank> accOp = bankDao.findById(reqAccount);
		if (!accOp.isPresent()) {
			return new BankResponse(reqAccount, "帳戶錯誤");
		}
		Bank acc = accOp.get();

		if (reqAccount.equals(acc.getAccount()) && bankUpdateRequest.getPwd().equals(acc.getPwd())
				&& StringUtils.hasText(bankUpdateRequest.getNewPwd())) {
			Bank bank = new Bank(reqAccount, bankUpdateRequest.getNewPwd());
			bankDao.save(bank);
			return new BankResponse(reqAccount, "密碼修改成功");
		}
		return new BankResponse(reqAccount, "密碼修改錯誤");
	}
}
