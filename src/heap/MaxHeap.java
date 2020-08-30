package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxHeap {
	List<Integer> heap;
	
	public MaxHeap(int data) {
		heap = new ArrayList<Integer>();
        heap.add(null); //1번 인덱스부터 시작하기 위해 0번 배열에 null 값 삽입
        heap.add(data);
	}

        public void insert(int data) {
            heap.add(data); //트리에 마지막 번에 데이터 삽입
            int n = heap.size() - 1;
            
            // 부모노드와 자식 노드 값 비교
            // 부모노드의 값이 자식 노드 보다 작으면
            // 부모노드와 자식 노드의 위치 변경
            while (n > 1 && heap.get(n / 2) < heap.get(n)) {
                int temp = heap.get(n / 2);
                
                heap.set(n / 2, heap.get(n));
                heap.set(n, temp);
                
                n = n / 2;
            }
            
        }
 
        //가장 큰 수 삭제
        public int delete() {
            if (heap.size()-1 < 1)
                return 0;
            
            int deleteItem = heap.get(1); // 삭제할 노드 = 루트노드
 
            //루트 노드에 가장 마지막 노드 대입
            heap.set(1, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1); //가장 마지막 노드 삭제
 
            int node = 1;
            
            while ((node * 2) < heap.size()) {
            	
                int max = heap.get(node * 2);
                int childNode = node * 2;
 
                //오른쪽 자식 노드 이고, 오른쪽 자식 노드의 값이 왼쪽 자식 노드의 값(max) 보다 크다면
                if (((node * 2 + 1) < heap.size()) && max < heap.get(node * 2 + 1)) {
                	//최대값 = 오른쪽 자식 노드의 값
                	max = heap.get(node * 2 + 1);
                	childNode = node * 2 + 1;
                }
                //현재 node의 값이 최대값 보다 크다면 
                if (heap.get(node) > max)
                    break;
                
                // 부모노드의 값이 자식노드보다 작기 때문에 두 개의 값 교환
                // 부모노드 => 자식 노드
                // 자식 노드 => 부모노드
                int tmp = heap.get(node);
                
                heap.set(node, heap.get(childNode));
                heap.set(childNode, tmp);
                node = childNode;
            }
 
            return deleteItem;
        }
    
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
 
        MaxHeap heap = new MaxHeap(n);
 
        for (int i = 0; i < n; i++) {
            int data = in.nextInt();
 
            if (data == 0) {
                System.out.println(heap.delete());
            } else {
                heap.insert(data);
            }
        }
 
    }

}