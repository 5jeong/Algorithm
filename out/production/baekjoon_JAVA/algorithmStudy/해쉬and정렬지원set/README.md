# 1️⃣Hash 알고리즘

### 해시 선언  
HashMap<Character,Integer> map = new HashMap<>(); 
### 해시 메소드   
* 해시에 값넣기   
→ map.put('a',3);     
  
* 해시의 key값   
map.keySet();   
  
* a(key)값의 value값   
map.get('a');   
  
* key의 value값의 default값을 0으로 설정  
map.getOrDefault(x,0)  
  
* key값이 포함되어있는지 확인(True,False)   
map.containsKey('a');   
  
* key의 개수   
map.size();   
  
* key값 삭제   
map.remove('a');  

# 2️⃣TreeSet 알고리즘  
✔균형잡힌 이진트리(중복제거 + 정렬)  
### TreeSet 선언  
* TreeSet<Integer> Tset = new TreeSet<>(); → 오름차순 정렬  
* TreeSet<Integer> Tset = new TreeSet<>(Comparator.reverseOrder()); → 내림차순 정렬  
### TreeSet 메소드  
* TreeSet에 값 추가  
Tset.add(1);  
Tset.add(2);
  
* TreeSet에 값 삭제     
Tset.remove(1);   
  
* TreeSet 크기 구하기  
Tset.size();  
  
* TreeSet 출력 
Tset.first(); // 첫번째 값 출력  
Tset.last(); // 마지막 값 출력  
