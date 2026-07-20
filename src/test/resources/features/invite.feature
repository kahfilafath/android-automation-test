Feature: Invite Friends & Get Rewards
  As a customer I want to be able to enjoy benefits of sharing referral code to friends

  Background:
    Given user input phone number "" on Login screen
    And user input password "" on Login screen
    When user click next button on Login screen
    Then user click Nanti on User Guide
    And user on the HomePage
    When user click Akun bottom navigation
    And user see the Ajak Teman Pakai Alfagift menu
    Then user click the Ajak Teman Pakai Alfagift menu

  @TC003
  Scenario: Verify user able to copy referral code
    Given user on the Ajak Teman page
    When user copy the referral code
    Then user should have referral code copied on the clipboard

  @TC004
  Scenario: Verify user able to share code
    Given user on the Ajak Teman page
    When user click the Ajak Teman Pakai Alfagift button
    Then user should see sharing text

  @TC005
  Scenario: Verify user able to see Cara Ajak Teman
    Given user on the Ajak Teman page
    When user click the Cara Ajak Teman button
    Then user should see the Cara Ajak Teman bottom sheet

  @TC006
  Scenario: Verify user able to view Teman yang kamu ajak Info
    Given user on the Ajak Teman page
    When user click the Teman yang kamu ajak info button
    Then user should see "Yang menggunakan kode referral kamu pada saat registrasi akan muncul di sini beserta jenis reward yang berlaku" on the bottom sheet

  @TC007
  Scenario: Verify user able to see detail of referral
    Given user on the Ajak Teman page
    When user click the referral benefit detail button
    Then user should see "Syarat Ketentuan" page

