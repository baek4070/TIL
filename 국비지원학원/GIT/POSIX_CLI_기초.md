# POSIX CLI

## 운영체제를 제어하는 방법

- GUI(Graphic User Interface) : 마우스 혹은 터치등으로 아이콘 혹은 버튼으로 조작하는 방법 , 매우많은 자원을 사용
- CLI(Command Line Interface) : 명령어를 이용해서 언어적, 물리적으로 컴퓨터를 조작하는 방법 , 적은자원으로도 동작가능, 서버 컴퓨터제어에 주로사용

## POSIX(Portable Operating System Interface)

- Unix계열의 컴퓨터들을 서로동일한 방법으로 제어하기위한 일종의 표준
- Unix, Linux, MacOS
- Window 는 CMD, PowerShell 을 사용( EMULATOR를 설치하면 POSIX 도 사용가능, Secure Shell을 사용해서 POSIX Server 와 연동해서 사용가능)

## CRUD

- Create
    - File : editor
    - Directory : mkdir
- Read
    - File : editor, cat, is
    - Directory : is
- Update
    - File : editor, mv
    - Directory : mv
- Delete
    - file: rm
    - Directory : rm

## 디렉토리의 사용

- 기본 커멘드
    - pwd(print working directory : 현재의 위치 확인
    - / : root directory(최상위 디렉토리)
    - rm(remove) : 현재 디렉토리 삭제, 조심할것
    - home directory : 기본적으로 터미널을 열었을때의 위치
    - cd : change directory
    - cd ~ : 현재 위치가 어디든간에 home directory로 이동
    - ls : file 의 list
    - —help : 사용설명이 내장된경우가 많음
    - man : 메뉴얼 ex ) mon ls [ls의 메뉴얼을 보여줘](—help가 안되면)
    - touch 파일이름.확장자 : make empty filemk
        1. ex) touch showfile.txt // showfile.txt 파일 생성
        2. ex) touch .hiddenfile.txt // hiddenfile.txt 숨긴파일 생성
- 현재 디렉토리의 상태보기와 명령어의 형식
    - ls -l : 파일 상세보기
        1. d 로 시작하면 디렉토리 
        2. -로 시작하면 파일
    - ls -a : show all filema
    - ls -l -a : 이런식으로도 사용가능
    - mkdir : make directory
    - ./ : current directorydir
    - mv : move(rename)
    - rm -r : remove directory
    - ../ parent directory
    - ; : command seperator
    - && : and operator

## 파일생성과 읽기

- nano :text editor
    - ex) nano hello.txt // hello.txt 파일이 열림
    - ex) cat hello.txt // 컵라면 처럼 파일을 보여줌
- rm 파일명.확장자 // 파일명 적다가 tap 키를 누르면 자동완성