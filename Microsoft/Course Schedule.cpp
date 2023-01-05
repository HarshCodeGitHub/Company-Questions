class Solution {

    // cycle detection in directed graph
    // if cycle is present -> return false  , else return true

    bool detectCycle(vector<vector<int>>& adj,int curridx,vector<int>& visited)
    {
        if(visited[curridx]==2)
            return true;
        
        visited[curridx] = 2;
        for(int i=0;i<adj[curridx].size();++i)
            if(visited[adj[curridx][i]]!=1)
                if(detectCycle(adj,adj[curridx][i],visited))
                    return true;
        
        visited[curridx] = 1;
        return false;
    }

public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        
        vector<vector<int>> adj(numCourses);
        vector<int> visited(numCourses,0);
        
        //Make adjacency matrix (Directed graph)
        for(int i=0;i<prerequisites.size();++i)
            adj[prerequisites[i][0]].push_back(prerequisites[i][1]);
        
       
        for(int i=0;i<numCourses;++i)
            if(visited[i]==0)
                if(detectCycle(adj,i,visited))
                    return false;
        
        return true;
    }
};
