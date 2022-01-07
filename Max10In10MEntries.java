//find max 10 numbers in a list having 10M entries

public ArrayList<Integer> findMax10(ArrayList<Integer>list){

    PriorityQueue<Integer>pq=new PriorityQueue<>();
    for(int i=0;i<list.size();++i){
        if(pq.size()<10) pq.add(list.get(i));
        else{
            if(pq.peek()<list.get(i)){
		pq.poll();
		pq.add(list.get(i));
            }
	}
    }
    ArrayList<Integer>max10=new ArrayList<>();
    while(!pq.isEmpty()) max10.add(pq.poll());
    return max10;
    
}